package ru.basics.server.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
    private static volatile SessionFactory sessionFactory;

    private SessionFactoryUtils() {
    }

    public static SessionFactory getInstance() {
        if (sessionFactory == null) {
            synchronized (SessionFactoryUtils.class) {
                if (sessionFactory == null) {
                    sessionFactory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .buildSessionFactory();
                }
            }
        }

        return sessionFactory;
    }
}
