package com.artcode.simplestore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String id;
    private Integer price;
    private String model;

    public ProductDTO(Integer price, String model) {
        this.price = price;
        this.model = model;
    }
}
