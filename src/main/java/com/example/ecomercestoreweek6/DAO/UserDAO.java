package com.example.ecomercestoreweek6.DAO;

import com.example.ecomercestoreweek6.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.ecomercestoreweek6.constants.QueryConstants.LOGIN_QUERY;
import static com.example.ecomercestoreweek6.constants.QueryConstants.REG_QUERY;

public class UserDAO {
    private Connection connection;

    private PreparedStatement statement;
    private ResultSet result;



    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User userLogin(String email, String password){
            User user = new User();
            try{

                statement =this.connection.prepareStatement(LOGIN_QUERY);
                statement.setString( 1,email);
                statement.setString( 2,password);
                result = statement.executeQuery();
                while(result.next()){

                    user.setUser_id(result.getInt("userId"));
                    user.setFirstName(result.getString("firstName"));
                    user.setLastName(result.getString("lastName"));
                    user.setEmail(result.getString("email"));

                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return user;
    }


    public boolean Register(User user){

        try{

            statement = this.connection.prepareStatement(REG_QUERY);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getAddress());
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}
