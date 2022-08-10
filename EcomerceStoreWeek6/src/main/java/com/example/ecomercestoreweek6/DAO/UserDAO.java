package com.example.ecomercestoreweek6.DAO;

import com.example.ecomercestoreweek6.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;
    private String query;
    private PreparedStatement statement;
    private ResultSet result;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User userLogin(String email, String password){
            User user = null;
            try{
                query = "select * from user where email =? and password =?";
                statement =this.connection.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, password);
                result = statement.executeQuery();
                if(result.next()){
                    user = new User();
                    user.setUser_id(result.getInt("user_id"));
                    user.setFirstName(result.getString("FirstName"));
                    user.setLastName(result.getString("lastName"));

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return user;
    }


    public String Register(User user){
        //User user = null;
        int abc;
        try{
            query = "insert into user(email,password,address,FirstName,LastName) values (?,?,?,?,?);";
            statement = this.connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.executeUpdate();
            return "Registration successful";

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Registration failed";
    }

}
