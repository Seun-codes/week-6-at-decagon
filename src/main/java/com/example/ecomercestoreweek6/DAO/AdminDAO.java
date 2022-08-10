package com.example.ecomercestoreweek6.DAO;

import com.example.ecomercestoreweek6.model.Admin;
import com.example.ecomercestoreweek6.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.ecomercestoreweek6.constants.QueryConstants.ADMIN_QUERY;
import static com.example.ecomercestoreweek6.constants.QueryConstants.REG_QUERY;

public class AdminDAO {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;
     String SignUp_Query = "INSERT INTO admin (email,password,name) VALUES(?,?,?)";
     String LogIn_Query = "SELECT * FROM admin WHERE email =? AND password =?";

    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    public Admin adminLogin(String email, String password){
            Admin admin = new Admin();
            try{
                statement = this.connection.prepareStatement(LogIn_Query);
                statement.setString( 1,email);
                statement.setString( 2,password);
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                    admin.setId(resultSet.getInt("id"));
                    admin.setEmail(resultSet.getString("email"));
                    admin.setPassword(resultSet.getString("password"));
                    admin.setName(resultSet.getString("name"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return admin;
    }
    public boolean Register(Admin admin){

        try{

            statement = this.connection.prepareStatement(SignUp_Query);
            statement.setString(1, admin.getPassword());
            statement.setString(2,admin.getEmail() );
            statement.setString(3, admin.getName());
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
