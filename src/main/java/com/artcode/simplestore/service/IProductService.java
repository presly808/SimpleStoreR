package com.artcode.simplestore.service;

import com.artcode.simplestore.entity.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);

    Product getProduct(String id);

    public List<Product> findByPriceMax();

    public List<Product> findByPriceMin();

    public List<Product> findByName();
}
