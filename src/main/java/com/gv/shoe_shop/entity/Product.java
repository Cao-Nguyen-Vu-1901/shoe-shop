package com.gv.shoe_shop.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {
    @MongoId
    private String id;  // Corresponds to MASANPHAM in SQL
    private String name;
    private double price;
    private int quantity;
    private String image;
    private String description;

    @DBRef
    private Category category; // Reference to Category

}

