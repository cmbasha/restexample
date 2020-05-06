package com.basha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basha.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
