package com.example.ecomercestoreweek6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int user_id;
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
    private String username;
    private String address;

    public User(String firstName, String lastName, String email, String password, String address) {
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User() {

    }


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
