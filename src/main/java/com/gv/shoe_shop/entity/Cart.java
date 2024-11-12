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
    private String id;  

    @DBRef
    private User user; 

    private List<CartItem> cartItems; 

    public static class CartItem {
        @DBRef
        private Product product; // Reference to Product

        private int quantity;
        private double price;

        public Product getProduct() {
            return product;
        }
        public int getQuantity() {
            return quantity;
        }
        public double getPrice() {
            return price;
        }
        public void setProduct(Product product) {
            this.product = product;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        public void setPrice(double price) {
            this.price = price;
        }
        
        
    }

}
