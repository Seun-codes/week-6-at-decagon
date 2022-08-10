package com.example.ecomercestoreweek6.constants;

public class QueryConstants {

    public static String REG_QUERY = "INSERT INTO Users (firstName,lastName,email, password,address) VALUES(?,?,?,?,?)";
    public  static String LOGIN_QUERY = "SELECT * FROM Users WHERE email =? AND password =?";

    public static String ADMIN_QUERY = "INSERT INTO admin (email,password,name) VALUES (?,?,?)";

}
