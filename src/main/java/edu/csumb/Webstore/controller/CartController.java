package edu.csumb.Webstore.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.Webstore.service.CartService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
public class CartController {

    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    CartService cartService;

    @ApiOperation(value = "Get all contents of a specific user’s cart.")
    @GetMapping ("/user/cart/{email}")
    public HashMap<String, Integer> getCart (String email) {
        return cartService.getCart(email);
    }

    @ApiOperation(value = "Add a product and corresponding quantity to a user's cart")
    @PostMapping("/user/cart/add/{email}/{id}/{quantity}")
    public String addProductToCart (@PathVariable String email, String id, Integer quantity) {
        return cartService.addProductToCart(email, id, quantity);
    }

    @ApiOperation(value = "Set a product to a specific quantity in a user's cart")
    @PostMapping("/user/cart/edit/{email}/{id}/{quantity}")
    public String changeProductInCart (@PathVariable String email, String id, Integer quantity) {
        return cartService.changeCartQuantity(email, id, quantity);
    }

    @ApiOperation(value = "Product stock is reduced and user cart is cleared")
    @PostMapping("/user/cart/checkout/{email}")
    public String checkout (@PathVariable String email) {
        return cartService.checkout(email);
    }    
}