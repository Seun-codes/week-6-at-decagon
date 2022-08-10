//package com.example.ecomercestoreweek6.model;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.testng.annotations.BeforeClass;
//
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class ShoppingCartTest {
//    private ShoppingCart cart;
//    private Product product;
//    private ShoppingCart cart1;
//
//  ;
//
//
//
//
//    @Test
//    void addItem() {
//       cart = new ShoppingCart();
//        product = new Product();
//        product.setId(1);
//        cart.addItem(product);
//
//
//        Map<Product, Integer> items = cart.getitems();
//        Integer quantity = items.get(product);
//        assertEquals(1,quantity);
//    }
//
//
//    @Test
//    void removeItems() {
//
//    }
//
//    @BeforeEach
//    void setUp() {
//        cart = new ShoppingCart();
//        product = new Product();
//        product.setId(1);
//        cart.removeItems(product);
//
//    }
//
//    @Test
//    void testRemoveItems() {
//        assertTrue(cart.getitems().isEmpty());
//    }
//
//    @Test
//    void getTotal() {
//        Product product1 = new Product();
//        cart.addItem(product1);
//        cart.addItem(product1);
//        cart.addItem(product1);
//
//        assertEquals(3,cart.getTotal());
//
//    }
//
//
//    @Test
//    void getTotalAmount() {
//       cart1 =new ShoppingCart();
//        assertEquals(0.0, cart1.getTotalAmount());
//
//    }
//
//    @Test
//    void getTotalAmount2(){
//       // assertEquals();
//    }
//}