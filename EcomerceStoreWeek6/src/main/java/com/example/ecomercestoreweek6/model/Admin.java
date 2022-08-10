package com.example.ecomercestoreweek6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Admin {
    private int admin_id;
    private String password;
    private String email;
    private String LastName;
    private String FirstName;

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                '}';
    }
}
