package com.taringamberini.reading.jph.ch02.helloworld.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Tarin Gamberini <www.taringamberini.com>
 */
public class JPAUtils {

    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("helloworldPersistenceUnit");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEMFactory() {
        // Alternatively, you could look up in JNDI here
        return emf;
    }
}
