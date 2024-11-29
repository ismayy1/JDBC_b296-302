import java.sql.*;

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

//        step 3: create a statement
        Statement statement = connection.createStatement();

//        step 4: Execute the query
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM employees");
        System.out.println("resultSet1 = " + resultSet1);   // return reference

        System.out.println(resultSet1.next());  // true




    }
}
