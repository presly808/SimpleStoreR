package com.artcode.simplestore.service;

import com.artcode.simplestore.entity.Product;
import com.artcode.simplestore.repository.ProductRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product addProduct(Product product) {
    String key = UUID.randomUUID().toString();
    product.setId(key);
    return productRepository.save(product);
  }

  @Override
  public Product getProduct(String id) {
    return productRepository.findById(id).orElse(null);
  }
}
