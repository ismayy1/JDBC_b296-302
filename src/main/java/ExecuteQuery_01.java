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
        System.out.println("===========TASK 1===========");

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM employees");
        System.out.println("resultSet1 = " + resultSet1);   // return reference

        /*
            System.out.println(resultSet1.next());  // true

            System.out.print(resultSet1.getInt("employee_id") + ", ");
            System.out.print(resultSet1.getString("employee_name") + ", ");
            System.out.println(resultSet1.getInt("salary"));

            System.out.println(resultSet1.next());  // true

            System.out.print(resultSet1.getInt("employee_id") + ", ");
            System.out.print(resultSet1.getString("employee_name") + ", ");
            System.out.println(resultSet1.getInt("salary"));

            System.out.println(resultSet1.next());  // true

            System.out.print(resultSet1.getInt("employee_id") + ", ");
            System.out.print(resultSet1.getString("employee_name") + ", ");
            System.out.println(resultSet1.getInt("salary"));

            System.out.println(resultSet1.next());  // true
         */

        while (resultSet1.next()) {
            System.out.print(resultSet1.getInt(1) + ", ");
            System.out.print(resultSet1.getString(2) + ", ");
            System.out.println(resultSet1.getInt(3));
        }

        System.out.println("===========TASK 2===========");
//          Get phone_code and country_name from the countries table where code is greater than 500
        ResultSet resultSet2 = statement.executeQuery("SELECT phone_code, country_name FROM countries WHERE phone_code > 500;");

        while (resultSet2.next()) {
            System.out.print(resultSet2.getInt(1) + ", ");
            System.out.println(resultSet2.getString(2));
        }

        System.out.println("===========TASK 3===========");
//        Create the following table using execute() or executeQuery()
        /*
            CREATE TABLE developers (id SERIAL PRIMARY KEY, name VARCHAR(50), salary REAL, prog_lang VARCHAR(20)
        );
         */

        boolean query1 = statement.execute(
                "CREATE TABLE developers (id SERIAL PRIMARY KEY, name VARCHAR(50), salary REAL, prog_lang VARCHAR(20)");
        System.out.println("query1 = " + query1);




    }
}
