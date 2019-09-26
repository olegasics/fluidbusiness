package ru.basics.server.entity.user;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.basics.server.DAO.DAO;
import ru.basics.server.DAO.UserDAO;

public class Auth extends CheckUserValid {

    SessionFactory sessionFactory = null;
     User resultUser = null;


    public User Authy(String key, String password) {

  try {
      sessionFactory = new Configuration().configure().buildSessionFactory();
   DAO<User, String> userDAO = new UserDAO(sessionFactory);
             resultUser = userDAO.read(key);

                if(checkUserForAuth(key, password, resultUser, userDAO) == 1) {
                    System.out.println(resultUser);
                    //реализовать логику, если пользователь ввел верный логин пароль
                }
        } catch (HibernateException e) {
      System.out.println("Ошибка с бд " + e);

  } catch (NullPointerException e) {
      System.out.println("Такого пользователя нет");
  }
    return resultUser;
    }

    @Override
    public String toString() {
        return "id_user: " + resultUser.getId() + "login_user: " + resultUser.getLogin();
    }


}
