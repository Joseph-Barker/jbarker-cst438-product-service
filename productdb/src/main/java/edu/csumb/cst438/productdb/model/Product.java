package edu.csumb.cst438.productdb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
    @Id
    private String id;
    private String name;
    private String category;
    private String description;
    private String imageURL;
    private Double price;
    private Integer stock;

    public Product (String name, String category,String description, String imageURL, Double  price, Integer stock) {
        this.name = name;
        this.category = category; 
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.stock = stock;
    }

    public String getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public String getCategory () {
        return this.category;
    }

    public String getDescription () {
        return this.description;
    }

    public String getImageURL () {
        return this.imageURL;
    }

    public Double getPrice () {
        return this.price;
    }

    public Integer getStock () {
        return this.stock;
    }

}