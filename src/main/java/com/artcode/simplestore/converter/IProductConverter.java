package com.artcode.simplestore.converter;

import com.artcode.simplestore.dto.ProductDTO;
import com.artcode.simplestore.entity.Product;

public interface IProductConverter {

  Product convert(ProductDTO input);

  ProductDTO convert(Product input);
}
