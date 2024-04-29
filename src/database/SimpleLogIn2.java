package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SimpleLogIn2 {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/devenvtests";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";

    public SimpleLogIn2() throws IOException {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM user WHERE name = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            System.err.println("What name to search for?");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();

            statement.setString(1, name);
            System.err.println(statement.toString());
            
            ResultSet resultSet = statement.executeQuery();

            // Go through the result set to print it
            while (resultSet.next()) {
                // Retrieve data by column name
                String userName = resultSet.getString("name");
                String userPass = resultSet.getString("password");

                System.out.println("userName: " + userName + ", userPass: " + userPass);
            }

            // Close external resources
            resultSet.close();
            statement.close();
            connection.close();
            sc.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new SimpleLogIn2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
