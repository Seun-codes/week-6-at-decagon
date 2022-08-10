package com.example.ecomercestoreweek6.model;






public class Product  {
    private int id;
    private String productCategory;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String image;

    public Product(int id, String productCategory, String productName, double productPrice, int productQuantity, String image) {
        this.id = id;
        this.productCategory = productCategory;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.image = image;
    }

    public Product(String productCategory, String productName, double productPrice, int productQuantity, String image) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.image = image;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + id +
                ", product_category='" + productCategory + '\'' +
                ", product_name='" + productName + '\'' +
                ", product_price=" + productPrice +
                ", product_quantity=" + productQuantity +
                ", image='" + image + '\'' +
                '}';
    }
}
