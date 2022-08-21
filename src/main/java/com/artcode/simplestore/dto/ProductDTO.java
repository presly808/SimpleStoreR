package com.artcode.simplestore.dto;

public class ProductDTO {

    private String id;
    private Integer price;
    private String model;

    public ProductDTO() {
    }

    public ProductDTO(Integer price, String model) {
        this.price = price;
        this.model = model;
    }

    public ProductDTO(String id, Integer price, String model) {
        this.id = id;
        this.price = price;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
