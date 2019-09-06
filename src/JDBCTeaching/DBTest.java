package JDBCTeaching;

import java.sql.*;

public class DBTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

       Class.forName("org.postgresql.Driver");

      final String user = "fluidbusiness";
        final  String password = "Edcvfr12!";
        final String url = "jdbc:postgresql://localhost:5432/fluidbusiness";

        final Connection connect = DriverManager.getConnection(url, user, password);

        try (PreparedStatement statement = connect.prepareStatement("SELECT * FROM users WHERE id = (?)")) {

           statement.setInt(1,1);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = "name" + resultSet.getString("user_name");
                System.out.println(name);
            }
        }
        finally {
            connect.close();

        }

    }
}

