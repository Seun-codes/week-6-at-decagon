package com.example.ecomercestoreweek6.DAO;

import com.example.ecomercestoreweek6.model.Carts;
import com.example.ecomercestoreweek6.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;
    private ResultSet resultSet;
    private String query;
    private PreparedStatement statement;


    public ProductDAO(Connection connection) {

        this.connection = connection;
    }


    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        try{
            query = "select * from Products";
            statement = this.connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setProductCategory(resultSet.getString("productCategory"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductQuantity(resultSet.getInt("productQuantity"));
                product.setProductPrice(resultSet.getInt("productPrice"));
                product.setImage(resultSet.getString("image"));

                products.add(product);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getSingleProduct(int product_id){
        Product row = null;
        try{
            query = "select * from  Products where id = ?";
            statement = this.connection.prepareStatement(query);
            statement.setInt(1, product_id);

            while(resultSet.next()){
                row = new Product();
                row.setId(resultSet.getInt("id"));
                row .setProductCategory(resultSet.getString("productCategory"));
                row.setProductName(resultSet.getString("productName"));
                row.setProductPrice(resultSet.getDouble("productQuantity"));
                row.setProductQuantity(resultSet.getInt("productPrice"));
                row.setImage(resultSet.getString("image"));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;


    }

    public List<Carts> getCartProducts(ArrayList<Carts> cartList){
        List<Carts> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Carts item : cartList) {
                    query = "select * from Products where id=?";
                    statement = this.connection.prepareStatement(query);
                    statement.setInt(1, item.getId());
                    resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Carts row = new Carts();
                        row.setId(resultSet.getInt("id"));
                        row.setProductName(resultSet.getString("productName"));
                        row.setProductCategory(resultSet.getString("productCategory"));
                        row.setProductPrice(resultSet.getDouble("productPrice") * item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }


    public double getTotalCartPrice(ArrayList<Carts> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Carts item : cartList) {
                    query = "select productPrice from products where id=?";
                    statement = this.connection.prepareStatement(query);
                    statement.setInt(1, item.getId());
                    resultSet =statement.executeQuery();
                    while (resultSet.next()) {
                        sum+= resultSet.getDouble("productPrice")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

    public boolean addProduct(Product product) {

        try {
            query = "INSERT INTO Products(productCategory,productName,productQuantity,productPrice,image) VALUES(?,?,?,?,?)";
       statement = this.connection.prepareStatement(query);
       statement.setString(1, product.getProductCategory());
       statement.setString(2, product.getProductName());
       statement.setInt(3, product.getProductQuantity());
       statement.setDouble(4, product.getProductPrice());
       statement.setString(5, product.getImage());
             int rs = statement.executeUpdate();
            if (rs > 0) {
               return true;
            }
} catch (SQLException e) {
            e.getMessage();
        }
        return false;
    }
}
