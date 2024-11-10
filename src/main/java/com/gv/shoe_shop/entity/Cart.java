package com.gv.shoe_shop.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "carts")
public class Cart {
    @MongoId
    private String id;  // Corresponds to MAGIOHANG in SQL

    @DBRef
    private User user; // Reference to Customer

    private List<CartItem> cartItems; // Embedded list of cart items

    // Getters and setters

    public static class CartItem {
        @DBRef
        private Product product; // Reference to Product

        private int quantity;
        private double price;

        // Getters and setters
    }

}
