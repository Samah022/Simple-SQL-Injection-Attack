package database;
import java.io.IOException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleLogIn {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/devenvtests";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";

    public SimpleLogIn() throws IOException {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Execute a query
            System.out.println("Creating statement...");
            Statement statement = connection.createStatement();

            System.err.println("What name to search for?");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            sc.close();
            
            String sql = "SELECT * FROM user where name = '" + name + "'";
            System.err.println("Query: "+sql);

            ResultSet resultSet = statement.executeQuery(sql);

            // Go through the result set to print it
            while (resultSet.next()) {
                // Retrieve data by column name
                String userName = resultSet.getString(2);
                String userPass = resultSet.getString(3);

                System.out.println("userName: " + userName + ", userPass: " + userPass);
            }

            // Close external resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new SimpleLogIn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}