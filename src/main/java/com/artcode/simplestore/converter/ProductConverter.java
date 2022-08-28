package com.artcode.simplestore.converter;

import com.artcode.simplestore.dto.ProductDTO;
import com.artcode.simplestore.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements IProductConverter {

    public Product convert(ProductDTO input) {
        return new Product(input.getId(), input.getPrice(), input.getModel());
    }

    public ProductDTO convert(Product input) {
        return new ProductDTO(input.getId(), input.getPrice(), input.getModel());
    }

}
