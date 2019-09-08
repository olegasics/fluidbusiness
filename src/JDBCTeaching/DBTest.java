package JDBCTeaching;
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
               String name =  resultSet.getString("user_name");
                System.out.println(name);
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