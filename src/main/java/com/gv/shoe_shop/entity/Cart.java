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

    public static class CartItem {
        @DBRef
        private Product product; // Reference to Product

        private int quantity;
        private double price;

        public CartItem(Product product, int quantity, double price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        public CartItem() {
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

}
