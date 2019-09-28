package ru.basics.server.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
     private static volatile SessionFactory sessionFactory;

    private SessionFactoryUtil() {}

    public static  SessionFactory getInstance() {
        if(sessionFactory == null) {
            synchronized (SessionFactoryUtil.class) {
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
