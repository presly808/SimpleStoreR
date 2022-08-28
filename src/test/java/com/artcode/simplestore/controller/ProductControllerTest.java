package com.artcode.simplestore.controller;

import com.artcode.simplestore.converter.ProductConverter;
import com.artcode.simplestore.dto.ProductDTO;
import com.artcode.simplestore.entity.Product;
import com.artcode.simplestore.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void addProduct() {
        // GIVEN
        ProductDTO productDTO = new ProductDTO(100, "Mp3");

        // WHEN
        ResponseEntity<ProductDTO> productDTOResponseEntity =
                restTemplate.postForEntity("/product", productDTO, ProductDTO.class);

        // THEN
        assertEquals(productDTOResponseEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(productDTOResponseEntity.getBody().getId());
    }

    @Test
    void getProduct() {
        // GIVEN
        ResponseEntity<ProductDTO> postEntity =
                restTemplate.postForEntity("/product", new ProductDTO(100, "Mp3"),
                        ProductDTO.class);

        ProductDTO postBody = postEntity.getBody();
        ResponseEntity<ProductDTO> getEntity = restTemplate
                .getForEntity("/product/{id}",  ProductDTO.class,
            Map.of("id", postBody.getId()));

        assertEquals(getEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(getEntity.getBody().getId());
        assertEquals(getEntity.getBody().getId(), postBody.getId());
    }

    @Test
    void findByPriceMax() {
        ProductService productService  = mock(ProductService.class);
        ProductConverter productConverter = mock(ProductConverter.class);

        ProductDTO productDTO1 = new ProductDTO(100, "MP4");
        ProductDTO productDTO2 = new ProductDTO(200, "MP3");
        ProductDTO productDTO3 = new ProductDTO(150, "Case");

        List<ProductDTO> products = new ArrayList<>();
        products.add(productDTO1);
        products.add(productDTO2);
        products.add(productDTO3);

        when(productService.findByPriceMax())
                .thenReturn(Collections.singletonList(productConverter.convert(products.get(1))));
        List<Product> result = productService.findByPriceMax();
        assertEquals(products.get(1), result);
    }

    @Test
    void findByPriceMin() {
    }

    @Test
    void findByName() {

    }
}