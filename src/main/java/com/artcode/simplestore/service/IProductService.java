package com.artcode.simplestore.service;

import com.artcode.simplestore.entity.Product;

public interface IProductService {

  Product addProduct(Product product);

  Product getProduct(String id);

}
