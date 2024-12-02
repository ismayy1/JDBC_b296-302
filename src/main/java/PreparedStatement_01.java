import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement_01 {
    public static void main(String[] args) throws SQLException {


        //        step 2; create connection with DataBase
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db_user", "db_user", "db_user");

        if (connection != null) {
            System.out.println("Connection is successful!");
        }else {
            System.out.println("Connection is not successful!");
        }

//        step 3: create a statement
        Statement statement = connection.createStatement();




        //        Close the DataBase connection
        System.out.println("========DataBase Connection is closed=========");
        if (connection != null){
            statement.close();
            connection.close();
            System.out.println("Connection is closed successfully!");

        }else {
            System.out.println("Connection is closed!");
        }

    }
}
