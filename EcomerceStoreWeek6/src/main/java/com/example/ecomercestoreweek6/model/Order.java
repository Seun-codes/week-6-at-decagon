package com.example.ecomercestoreweek6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Order {
    private int order_id;
    private int user_id;
    private String product_name;
    private int product_id;

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", product_name='" + product_name + '\'' +
                ", product_id=" + product_id +
                '}';
    }
}
