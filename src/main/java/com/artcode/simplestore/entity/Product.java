package com.artcode.simplestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

  @Id
  private String id;
  @Column
  private Integer price;
  @Column
  private String model;

  public Product() {
  }

  public Product(String id, Integer price, String model) {
    this.id = id;
    this.price = price;
    this.model = model;
  }

  public String getId() {
    return id;
  }

  public Product setId(String id) {
    this.id = id;
    return this;
  }

  public Integer getPrice() {
    return price;
  }

  public Product setPrice(Integer price) {
    this.price = price;
    return this;
  }

  public String getModel() {
    return model;
  }

  public Product setModel(String model) {
    this.model = model;
    return this;
  }
}
