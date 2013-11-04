package com.taringamberini.reading.jph.ch02.helloworld;

import com.taringamberini.reading.jph.ch02.helloworld.persistence.JPAUtils;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.HibernateException;
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
        EntityManager em = JPAUtils.getEMFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Message message = new Message("Hello World");
        em.persist(message);
        tx.commit();
        em.close();

        // Second unit of work
        getAllMessages();

        // Shutting down the application
        JPAUtils.getEMFactory().close();
    }

    private void getAllMessages() throws HibernateException {
        EntityManager em = JPAUtils.getEMFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Message> messages = em
                .createQuery("select m from Message m order by m.text asc")
                .getResultList();
        LOGGER.debug("{} message(s) found", messages.size());
        for (Message msg : messages) {
            LOGGER.debug(msg.toString());
        }
        tx.commit();
        em.close();
    }
}
