import java.sql.*;

public class ExecuteUpdate_01 {
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




//        12.02.2024


        System.out.println("=================== Task 3 ===================");
//        Delete the rows from developers table where prog_lang is 'Ruby'
        String query3 = "DELETE FROM developers WHERE prog_lang ILIKE 'RUBY';";

        int thirdUpdate = statement.executeUpdate(query3);
        System.out.println("thirdUpdate = " + thirdUpdate);

        ResultSet resultSet3 = statement.executeQuery("SELECTY * FROM developers");

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
