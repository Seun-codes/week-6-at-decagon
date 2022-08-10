package com.example.ecomercestoreweek6.DAO;

import com.example.ecomercestoreweek6.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;
    private ResultSet result;
    private String query;
    private PreparedStatement statement;

    public ProductDAO(Connection connection) {

        this.connection = connection;
    }


    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        try{
            query = "select * from Product";
            statement = this.connection.prepareStatement(query);
            result = statement.executeQuery();

            while(result.next()){
                Product product = new Product();
                product.setProduct_category(result.getString("product_category"));
                product.setProduct_name(result.getString("product_name"));
                product.setProduct_quantity(result.getInt("product_quantity"));
                product.setProduct_price(result.getInt("product_price"));
                product.setImage(result.getString("image"));

                products.add(product);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
