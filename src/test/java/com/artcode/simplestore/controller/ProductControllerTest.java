package com.artcode.simplestore.controller;

import com.artcode.simplestore.dto.ProductDTO;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

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
        Assertions.assertEquals(productDTOResponseEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(productDTOResponseEntity.getBody().getId());
    }

    @Test
    void getProduct() {
        // GIVEN
        ResponseEntity<ProductDTO> postEntity =
                restTemplate.postForEntity("/product", new ProductDTO(100, "Mp3"), ProductDTO.class);

        ProductDTO postBody = postEntity.getBody();
        ResponseEntity<ProductDTO> getEntity = restTemplate.getForEntity("/product/{id}",  ProductDTO.class,
            Map.of("id", postBody.getId()));

        Assertions.assertEquals(getEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(getEntity.getBody().getId());
        Assertions.assertEquals(getEntity.getBody().getId(), postBody.getId());
    }
}