package com.gv.shoe_shop.repository;

import com.gv.shoe_shop.entity.Product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByDeletedDateIsNull();
}
