import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExecuteQuery_01 {
    public static void main(String[] args) throws SQLException {


//        step 2; create connection with DataBase
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db_user", "db_user", "db_user");

        if (connection != null) {
            System.out.println("Connection is successful!");
        }else {
            System.out.println("Connection is not successful!");
        }


    }
}
