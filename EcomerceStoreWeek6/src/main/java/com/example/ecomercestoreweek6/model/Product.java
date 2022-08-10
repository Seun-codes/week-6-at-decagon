package com.example.ecomercestoreweek6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int product_id;
    private String product_category;
    private String product_name;
    private double product_price;
    private int product_quantity;
    private String image;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_category='" + product_category + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_quantity=" + product_quantity +
                ", image='" + image + '\'' +
                '}';
    }
}
