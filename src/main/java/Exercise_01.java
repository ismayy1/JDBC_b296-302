import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise_01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

         /*
        NOTES:

        pgAdmin4 is used for
            1. Manual Testing of DB by QAs
            2. Creating tabular structure, adding values etc. by Devs

        pgAdmin4 is GUI(Graphic User Interface) for PostgresSQL Database.

        JDBC Driver is used for AUTOMATION of Database.

        To create connection with DB, we need to follow these steps:
        Step 1: Register the Driver class (OPTIONAL)
        Step 2: Create connection with Database
        Step 3: Create a Statement
        Step 4: Execute the query
        Step 5: Close the connection


         */


//        Step 1: Register the Driver class (OPTIONAL since Java 7)
        Class.forName("org.postgresql.Driver");

//        Step 2: Create connection with Database
//        PLEASE check the port number if you get an error => port: 5432 OR 5433
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db_user", "db_user", "db_user");

        if (connection != null) {
            System.out.println("Connection is successful!");
        }else {
            System.out.println("Connection is not successful!");
        }


//        Step 3: Create a Statement

        Statement statement = connection.createStatement();

//        Step 4: Execute the query

//        CREATE TABLE IF NOT EXISTS employees (
//                employee_id INT,
//                employee_name VARCHAR (20),
//                salary REAL
//        )
        boolean query1 = statement.execute(
                "CREATE TABLE IF NOT EXISTS employees (employee_id INT, employee_name VARCHAR (20), salary REAL);");
        System.out.println("query1 = " + query1);

        /*
             execute() -> returns us boolean
             execute() -> is used with DDL (CREATE, ALTER, DROP table), with DQL (reading the data using SELECT)
                          and DML (INSERT INTO, UPDATE)
             With some queries, execute() returns FALSE, with some other, it returns TRUE
        */

//        INSERT INTO employees VALUES (01, 'John Doe', 5000)   created in pgAdmin
//        boolean query2 = statement.execute("INSERT INTO employees VALUES (01, 'John Doe', 5000)");
//        boolean query2 = statement.execute("INSERT INTO employees VALUES (01, 'Alice Can', 5000)");
//        System.out.println("query2 = " + query2);   // false, bcs execute() is used with DML query

        // Let's read the data now using SELECT (DQL query)
        // SELECT * FROM employees;
        boolean query3 = statement.execute("SELECT * FROM employees;");
        System.out.println("query3 = " + query3);


//        Step 5: Close the connection

        if (connection != null){
            statement.close();
            connection.close();
            System.out.println("Connection is closed successfully!");

        }else {
            System.out.println("Connection is closed!");
        }

    }
}
