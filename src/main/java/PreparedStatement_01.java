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
        System.out.println("rowsUpdated2 = " + rowsUpdated2);

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM departments;");

        while (resultSet1.next()) {
            System.out.println(resultSet2.getInt("pass_grade") + " - " + resultSet2.getString("department"));
        }


        System.out.println("==================Task 3==================");
//        Task 3: Upgrade the pass_grade to 490 for Management department
        preparedStatement1.setInt(1, 490);
        preparedStatement1.setString(2, "Management");

        int rowsUpdated3 = preparedStatement1.executeUpdate();
        System.out.println("rowsUpdated3 = " + rowsUpdated3);

        ResultSet resultSet3 = statement.executeQuery("SELECT * FROM departments;");

        while (resultSet1.next()) {
            System.out.println(resultSet3.getInt("pass_grade") + " - " + resultSet3.getString("department"));
        }


        System.out.println("==================Task 4==================");
//        Task 4: Delete Students whose department is Mathematics
//        String query2 = "DELETE FROM departments WHERE department ILIKE 'Mathematics';";
        String query2 = "DELETE FROM departments WHERE department ILIKE ? ;";    // parameterized query

        PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
        preparedStatement2.setString(1, "Mathematics");

        int rowsUpdated4 = preparedStatement2.executeUpdate();
        System.out.println("rowsUpdated4 = " + rowsUpdated4);

        ResultSet resultSet4 = statement.executeQuery("SELECT * FROM students;");

        while (resultSet4.next()) {
            System.out.println(resultSet4.getInt("id")
                    + " - " + resultSet4.getString("name")
                    + " - " + resultSet4.getInt("grade")
                    + " - " + resultSet4.getString("department"));
        }

        System.out.println("==================Task 5==================");
//        Task 5: Delete students whose department is Psychology
        preparedStatement2.setString(1, "Psychology");

        int rowsUpdated5 = preparedStatement2.executeUpdate();
        System.out.println("rowsUpdated5 = " + rowsUpdated5);

        ResultSet resultSet5 = statement.executeQuery("SELECT * FROM students;");

        while (resultSet5.next()) {
            System.out.println(resultSet5.getInt("id")
                    + " - " + resultSet5.getString("name")
                    + " - " + resultSet5.getInt("grade")
                    + " - " + resultSet5.getString("department"));
        }


        System.out.println("==================Task 6==================");
//        Insert a "Software Development" into departments table
//        Normal query

//        String query3 = "INSERT INTO departments VALUES (5006, 'Software Development', 499, 'North');";
        String query3 = "INSERT INTO departments VALUES (?, ?, ?, ?);"; // parametrized query

        PreparedStatement preparedStatement3 = connection.prepareStatement(query3);

        preparedStatement3.setInt(1, 5006);
        preparedStatement3.setString(2, "Software Development");
        preparedStatement3.setInt(3, 499);
        preparedStatement3.setString(4, "North");

        int rowsUpdated6 = preparedStatement3.executeUpdate();
        System.out.println("rowsUpdated6 = " + rowsUpdated6);

        ResultSet resultSet6 = statement.executeQuery("SELECT * FROM departments");

        while (resultSet6.next()) {
            System.out.println(resultSet5.getInt("dept_id")
                    + " - " + resultSet5.getString("department")
                    + " - " + resultSet5.getInt("pass_grade")
                    + " - " + resultSet5.getString("campus"));
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
