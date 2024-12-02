import java.sql.*;

public class ExecuteUpdate_01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db_user", "db_user", "db_user");

        if (connection != null) {
            System.out.println("Connection is successful!");
        }else {
            System.out.println("Connection is not successful!");
        }

        Statement statement = connection.createStatement();

//        Update salaries of developers whose salaries are less than average salary with average salary
        /*
        UPDATE developers SET salary = (SELECT AVG(salary) FROM developers) where salary < (SELECT AVG(salary) FROM developers);
         */
        String query1 = "UPDATE developers SET salary = (SELECT AVG(salary) FROM developers) where salary < (SELECT AVG(salary) FROM developers);";

        int rowsUpdated = statement.executeUpdate(query1);
        System.out.println("rowsUpdated = " + rowsUpdated);

//        NOTE: executeUpdate() returns the number of rows that get updated

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM developers;");

        while (resultSet1.next()) {
            System.out.println(resultSet1.getString("name") + " - " + resultSet1.getInt("salary"));
        }



//        12.02.2024

        System.out.println("=================== Task 3 ===================");
//        Delete the rows from developers table where prog_lang is 'Ruby'
        String query3 = "DELETE FROM developers WHERE prog_lang ILIKE 'RUBY';";

        int thirdUpdate = statement.executeUpdate(query3);
        System.out.println("thirdUpdate = " + thirdUpdate);

        ResultSet resultSet3 = statement.executeQuery("SELECT * FROM developers");

        while (resultSet3.next()) {
            System.out.println(resultSet3.getInt("id") +
                    " = " + resultSet3.getString("name") +
                    " - " + resultSet3.getString("prog_lang"));
        }



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
