import java.sql.*;

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

        System.out.println("==================Task 1==================");
//        Task 1: Upgrade the pass_grade to 475 for Mathematics department

//        String query1 = "UPDATE departments SET pass_grade = 475 WHERE department ILIKE 'Mathematics';";
//        String query2 = "UPDATE departments SET pass_grade = 480 WHERE department ILIKE 'Psychology';";
//        String query3 = "UPDATE departments SET pass_grade = 490 WHERE department ILIKE 'Management';";
//        String query4 = "UPDATE departments SET pass_grade = 450 WHERE department ILIKE 'Literature';";

//        dynamic query / parameterised query
        String query1 = "UPDATE departments SET pass_grade = ? WHERE department ILIKE ? ;";

        PreparedStatement preparedStatement1 = connection.prepareStatement(query1);

        preparedStatement1.setInt(1, 475);
        preparedStatement1.setString(2, "Mathematics");


//        Now use executeUpdate() to update
        int rowsUpdated1 = preparedStatement1.executeUpdate();
        System.out.println("rowsUpdated = " + rowsUpdated1);

//        To see the data
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM departments;");

        while (resultSet1.next()) {
            System.out.println(resultSet1.getInt("pass_grade") + " - " + resultSet1.getString("department"));
        }


        System.out.println("==================Task 2==================");
//        Task 2: Upgrade the pass_grade to 450 for Literature department
        preparedStatement1.setInt(1, 450);
        preparedStatement1.setString(2, "Literature");

        int rowsUpdated2 = preparedStatement1.executeUpdate();

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM departments;");

        while (resultSet1.next()) {
            System.out.println(resultSet2.getInt("pass_grade") + " - " + resultSet2.getString("department"));
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
