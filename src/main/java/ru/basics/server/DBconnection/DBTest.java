package main.java.ru.basics.server.DBconnection;
import java.sql.*;

public class DBTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Нет драйвера postgresql" + e);
        }

        System.out.println("Драйвер postgresql подключен");

      final String user = "fluidbusiness";
        final  String password = "Edcvfr12!";
        final String url = "jdbc:postgresql://94.103.90.9:5432/fluidbusiness";
        Connection connect = null;

        try {
    connect = DriverManager.getConnection(url, user, password);

    } catch (SQLException e ) {
    System.out.println("Нет подключения к БД" + e);
    }

    if(connect != null )    System.out.println("Подключились к базе данных");
        else System.out.println("Не удалось подключиться к БД");


        try (PreparedStatement statement = connect.prepareStatement("SELECT * FROM users  WHERE id = (?)")) {
        //try {
            statement.setInt(1,1);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
               String name =  resultSet.getString("user_name");
               String login = resultSet.getString("user_login");
               String psw = resultSet.getString("user_password");
               String phone = resultSet.getString("user_phone");
               String city = resultSet.getString("user_city ");
                System.out.println("id " + "|" + " user_name " + "|" + " user_login " + "|" + " user_password " + "|" + " user_phone " + "|" + " user_city ");
                System.out.println(id  + " | " + name + " | "  + login+ " | " + psw + " | " + phone+ " | " + city   );
                //System.out.println("dsd");
            } else {
                System.out.println("Не зашло в иф");
            }
        }
        catch (SQLException e) {
            System.out.println("Что то пошло нет так" + e);
        }

        finally {

            connect.close();

        }

    }
}