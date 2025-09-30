package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/Micro_Credit_db";
    private static final String username = "postgres";
    private static final String password = "barca1230/";
    private static DBConnection instance = null;
    private static Connection connection = null;

    public DBConnection(){
        try {
            try{
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e){
                System.err.println("JDBC Driver not found: " + e.getMessage());
            }
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");
        } catch (SQLException e){
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static Connection getInstance(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance.getConnection();
    }

    public void testQuery(){
        String query = "SELECT * FROM personne";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()){
                System.out.println(rs.getString("nom"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
