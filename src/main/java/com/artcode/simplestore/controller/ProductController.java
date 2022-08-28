package com.artcode.simplestore.controller;

import com.artcode.simplestore.converter.IProductConverter;
import com.artcode.simplestore.dto.ProductDTO;
import com.artcode.simplestore.entity.Product;
import com.artcode.simplestore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private IProductConverter productConverter;

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        final Product product = productService.addProduct(productConverter.convert(productDTO));
        return ResponseEntity.ok(productConverter.convert(product));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") String id) {
        return ResponseEntity.ok(productConverter.convert(productService.getProduct(id)));
    }

    @GetMapping("/products/price/{priceMax}")
    public ResponseEntity<List<Product>> findByPriceMax() {
        List<Product> byName = productService.findByPriceMax();
        return getResponseEntity(byName);
    }

    @GetMapping("/products/price/{priceMin}")
    public ResponseEntity<List<Product>> findByPriceMin() {
        List<Product> byName = productService.findByPriceMin();
        return getResponseEntity(byName);
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<List<Product>> findByName(@PathVariable String name) {
        List<Product> byName = productService.findByName();
        return getResponseEntity(byName);
    }

    private static ResponseEntity<List<Product>> getResponseEntity(List<Product> byName) {
        return byName != null && !byName.isEmpty()
                ? new ResponseEntity<>(byName, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
