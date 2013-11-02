package com.taringamberini.reading.jph.ch02.helloworld;

import com.taringamberini.reading.jph.ch02.helloworld.persistence.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tarin Gamberini <www.taringamberini.com>
 */
public class HelloWorld {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    public void sayHello() {
        // First unit of work
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Message message = new Message("Hello World");
        Long helloWorldMessageId = (Long) session.save(message);
        tx.commit();
        session.close();

        // Second unit of work
        getAllMessages();

        // Third unit of work
        Session thirdSession = HibernateUtil.getSessionFactory().openSession();
        Transaction thirdTransaction = thirdSession.beginTransaction();
        message = (Message) thirdSession.get(Message.class, helloWorldMessageId);
        message.setText("Ciao, come stai?");
        message.setNextMessage(new Message("Sto bene, grazie."));
        thirdTransaction.commit();
        thirdSession.close();

        // forth unit of work
        getAllMessages();

        // Shutting down the application
        HibernateUtil.getSessionFactory().close();
    }

    private void getAllMessages() throws HibernateException {
        Session newSession = HibernateUtil.getSessionFactory().openSession();
        Transaction newTransaction = newSession.beginTransaction();

        List<Message> messages = newSession.createQuery("from Message m order by m.text asc").list();
        LOGGER.debug("{} message(s) found", messages.size());
        for (Message msg : messages) {
            LOGGER.debug(msg.toString());
        }
        newTransaction.commit();
        newSession.close();
    }
}
