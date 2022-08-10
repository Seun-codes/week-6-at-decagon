package com.example.ecomercestoreweek6.Utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static Connection connection = null;


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Base","root","yourpasswd" );

        }
        return connection;
    }

}
