package com.artcode.simplestore.repository;

import com.artcode.simplestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, String> {

    public List<Product> findByPriceMax();

    public List<Product> findByPriceMin();

    public List<Product> findByName();
}
