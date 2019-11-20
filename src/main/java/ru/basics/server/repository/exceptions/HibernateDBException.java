package ru.basics.server.repository.exceptions;

import org.hibernate.HibernateException;

public class HibernateDBException extends RuntimeException {

    public HibernateDBException() {
        super("Ошибка при работе с базой данных");
    }

    public HibernateDBException(String e) {
        super("Ошибка при работе с базой данных " + e);
    }

}
