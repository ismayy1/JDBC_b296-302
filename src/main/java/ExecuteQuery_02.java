import java.sql.*;

public class ExecuteQuery_02 {
    public static void main(String[] args) throws SQLException {

//        Step 1: Create Connection
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db_user", "db_user", "db_user");

//        Step 2: Create Statement
        Statement statement = connection.createStatement();

//        Step 3: Execute query
        System.out.println("================ Task 1 ================");
//        Display the names of the students and their grades if their grades are higher than the pass grade of their department
        /*
        SELECT name, grade FROM students INNER JOIN departments ON students.department = departments.department WHERE students.grade > departments.pass_grade;
         */
        String query1= "SELECT name, grade FROM students INNER JOIN departments ON " +
                "students.department = departments.department WHERE students.grade > departments.pass_grade;";
        ResultSet resultSet1 = statement.executeQuery(query1);

        while (resultSet1.next()) {
            System.out.println(resultSet1.getString("name") + " - " + resultSet1.getInt("grade"));
        }



        System.out.println("================ Task 2 ================");
//        Print department name and grade of department which has the second-highest pass_grade
        String query2 = "SELECT department, pass_grade FROM departments ORDER BY pass_grade DESC LIMIT 1 OFFSET 1;";

        ResultSet resultSet2 = statement.executeQuery(query2);

        while (resultSet2.next()) {
            System.out.println(resultSet2.getString("department") + " - " + resultSet2.getInt("pass_grade"));
        }


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
