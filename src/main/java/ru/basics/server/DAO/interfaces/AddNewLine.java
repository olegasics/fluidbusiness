package ru.basics.server.DAO.interfaces;

import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public interface AddNewLine<T> {

    SessionFactory sessionFactoty = null;
   // List<T> entities = new ArrayList<>();

    public T initizial();

    public void addNewLine(T t);


}
