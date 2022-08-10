package com.example.ecomercestoreweek6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Likes {
    private int user_id;
    private int product_id;
    private String product_name;



    @Override
    public String toString() {
        return "Likes{" +
                "user_id=" + user_id +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                '}';
    }
}
