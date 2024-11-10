package com.gv.shoe_shop.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    @MongoId
    private String id;  // Corresponds to MAHOADON in SQL

    @DBRef
    private User user; // Reference to Customer

    private LocalDate createdDate;

    private String status;

    private String address;

    private List<OrderDetail> orderDetails; // Embedded list of order details

    public static class OrderDetail {
        @DBRef
        private Product product; // Reference to Product

        private int quantity;
        private double price;

        // Getters and setters
    }

}
