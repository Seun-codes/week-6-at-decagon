package com.example.ecomercestoreweek6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Admin {
    private int id;
    private String password;
    private String email;
    private String name;

    public Admin(String password, String email, String name) {
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", FirstName='" + name + '\'' +
                '}';
    }
}
