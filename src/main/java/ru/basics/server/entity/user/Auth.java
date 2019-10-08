package ru.basics.server.entity.user;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import ru.basics.server.DAO.DAO;
import ru.basics.server.DAO.UserDAO;
import ru.basics.server.connection.SessionFactoryUtil;

import java.util.List;

public class Auth extends CheckUserValid {

    SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
     User resultUser = null;

     public User AuthyByLogin (String login, String password) {
         try {
             DAO<User, String> userDAO = new UserDAO(sessionFactory);
             resultUser = userDAO.read(login);
             if(checkUserForAuth(login, password, resultUser, userDAO, sessionFactory) == 1) {
                 System.out.println(resultUser);
             }

         } catch (HibernateException e ) {
             System.out.println("Ошибка при авторизации" + e);
         }
         return resultUser;
     }


//    public User Authy(String key, String password) {
//
//  try {
//      sessionFactory = SessionFactoryUtil.getInstance();
//   DAO<User, String> userDAO = new UserDAO(sessionFactory);
//             resultUser = userDAO.read(key);
//
//                if(checkUserForAuth(key, password, resultUser, userDAO) == 1) {
//                    System.out.println(resultUser);
//                    //реализовать логику, если пользователь ввел верный логин пароль
//                }
//        } catch (HibernateException e) {
//      System.out.println("Ошибка с бд " + e);
//
//  } catch (NullPointerException e) {
//      System.out.println("Такого пользователя нет");
//  }
//    return resultUser;
//    }

    @Override
    public String toString() {
        return "login_user: " + resultUser.getLogin();
    }


}
