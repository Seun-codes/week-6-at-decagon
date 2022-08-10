package com.example.ecomercestoreweek6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Carts extends Product {

    private int quantity;

    public Carts() {
    }

    public Carts(int id, String productCategory, String productName, double productPrice, int productQuantity, String image, int quantity) {
        super(id, productCategory, productName, productPrice, productQuantity, image);
        this.quantity = quantity;
    }

    public Carts(int quantity) {
        this.quantity = quantity;
    }
}
