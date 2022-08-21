package com.artcode.simplestore.controller;

import com.artcode.simplestore.converter.IProductConverter;
import com.artcode.simplestore.dto.ProductDTO;
import com.artcode.simplestore.entity.Product;
import com.artcode.simplestore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private IProductConverter productConverter;

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        final Product product = productService.addProduct(productConverter.convert(productDTO));
        return ResponseEntity.ok(productConverter.convert(product));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") String id) {
        return ResponseEntity.ok(productConverter.convert(productService.getProduct(id)));
    }


}
