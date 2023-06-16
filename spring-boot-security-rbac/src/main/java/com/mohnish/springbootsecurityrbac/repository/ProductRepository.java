package com.mohnish.springbootsecurityrbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohnish.springbootsecurityrbac.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
