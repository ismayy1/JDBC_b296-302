import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery_02 {
    public static void main(String[] args) throws SQLException {

//        Step 1: Create Connection
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db_user", "db_user", "db_user");

//        Step 2: Create Statement
        Statement statement = connection.createStatement();

//        Step 3: Execute query
        System.out.println("================ Task 1 ================");

//        Step 4: Close Connection
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
