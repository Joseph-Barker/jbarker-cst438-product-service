//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Product")
public class Product {
    @Id
    @ApiModelProperty(required = false, hidden = true)
    private String id;
    private String name;
    private String category;
    private ArrayList<String> description = new ArrayList<String>();
    private String imageURL;
    private Double price;
    private Integer stock;

    public Product (String name, String category, ArrayList<String> description, String imageURL, Double  price, Integer stock) {
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

    public ArrayList<String> getDescription () {
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
    
    public void decreaseStock (Integer outboundStock) {
        this.stock -= outboundStock;
    }

}