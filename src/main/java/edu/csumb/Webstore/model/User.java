//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
@Document(collection = "Users")
public class User {
    @Id
    private String email;
    private String password;
    @ApiModelProperty(required = false, hidden = true)
    private HashMap<String, Integer> cart = new HashMap<>();
    
    public User (String email, String password, HashMap<String, Integer> cart) {
        this.email = email;
        this.password = password; 
        this.cart = cart;
    }

    public String getEmail () {
        return this.email;
    }

    public String getPassword () {
        return this.password;
    }

    public HashMap<String, Integer> getCart () {
        return this.cart;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public void setCart (HashMap<String, Integer> cart) {
        this.cart = cart;
    }

    public void updateQuantity (String id, Integer quantity) {
        this.cart.put(id,quantity);
    }

    public void removeProductFromCart (String id){
        this.cart.remove(id);
    }
}