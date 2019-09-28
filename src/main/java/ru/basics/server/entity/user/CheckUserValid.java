package ru.basics.server.entity.user;

import ru.basics.server.DAO.DAO;

public class CheckUserValid  {
    //SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    //DAO<User, String> userDAO = new UserDAO(sessionFactory);
    byte status;

    /**
     *
     * @param login
     * @param user
     * @param userDAO
     * @return
     * status is 1 - user is valid
     * status is 0 - user dont valid
     */
    public byte checkUserForRegistration(String login, User user, DAO<User,String> userDAO) {
         user = userDAO.read(login);
            if(user.getLogin() != null) {
                status = 1;
            } else {
                status = 0;
            }

            return status;
    }

    public byte checkUserForAuth(String login, String password, User user, DAO<User, String> userDAO) {
         user = userDAO.read(login);
        if(checkUserForRegistration(login, user, userDAO) == 1) {
            if (password.equals(user.getPassword())) {
                status = 1;
            } else {
                System.out.println("Введен не верный пароль");
                status = 0;
            }
        } else {
            System.out.println("Пользователь с введенным логином не существует");
            status = 0;
        }
        return status;
        }

}


