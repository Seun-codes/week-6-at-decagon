package com.example.ecomercestoreweek6.constants;

import com.example.ecomercestoreweek6.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    private Connection connection;
    private PreparedStatement statement;


    String AddToCart_Query = "select quantity from Cart where  userId =? and productId =?";
    String  Queue_Query = "update Cart set quantity =? where userId =? and productId=?";

    public CartDAO() {
        this.connection = connection;
    }

    public boolean AddToCart(int userId, int quantity, int productId){
        try {
            statement = this.connection.prepareStatement(AddToCart_Query);
            statement.setInt(1, userId);
            statement.setInt(2,productId);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                int quanti = result.getInt("quantity");
                quantity = quantity * quanti;

                statement =this.connection.prepareStatement(Queue_Query);
                statement.setInt(1, userId);
                statement.setInt(2,productId);
                statement.setInt(3,quantity);
                int result1 = statement.executeUpdate();
                if(result1 > 0) return true;


            }else {
                String exception = "insert into Cart(userId,productId,quantity) values(?,?,?)";
                statement =this.connection.prepareStatement(exception);
                statement.setInt(1, userId);
                statement.setInt(2,productId);
                statement.setInt(3,quantity);
                int result1 = statement.executeUpdate();
                if(result1 > 0) return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public List<Product> GetCart(int userId) {
        List<Product> products = new ArrayList<>();
        try {
            String Query = "SELECT ProductCategory,productName,productQuantity,productPrice," +
                    "Id FROM Products INNER JOIN Cart ON Cart.productId = Products.Id AND Cart.userId = ?";
            statement =this.connection.prepareStatement(Query);
            statement.setInt(1,userId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){

                Product product = new Product();
               // product.setId(resultSet.getInt("id"));
                product .setProductCategory(resultSet.getString("productCategory"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductPrice(resultSet.getDouble("productQuantity"));
                product.setProductQuantity(resultSet.getInt("productPrice"));
                product.setImage(resultSet.getString("image"));

                products.add(product);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public boolean deleteFromCart(int productId, int userId ) throws SQLException {
        String Query = "DELETE from Cart WHERE productId = ? and userId = ?";
        statement = this.connection.prepareStatement(Query);
        statement.setInt(1,userId);
        statement.setInt(2,productId);

        int resultSet2 =statement.executeUpdate();
        if(resultSet2 > 0) return true;
        return false;
    }
}
