package edu.csumb.cst438.productdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.cst438.productdb.model.Product;
import edu.csumb.cst438.productdb.service.ProductService;
import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {

    @Autowired  
    ProductService productService;

    @ApiOperation(value = "Get all products from the database.")
    @GetMapping ("/products/getAll")
    public List<Product> getAll () {
        return productService.getAll();
    }
    
    @ApiOperation(value = "Get a specific product from the database by it's ID.")
    @GetMapping("/products/get/{id}")
    public Product getProductById (@PathVariable String id) {
        return productService.getProductById(id);
    }

    @ApiOperation(value = "Get all products of a specific category.")
    @GetMapping("/products/category/{category}")
    public List<Product> getByCategory (@PathVariable String category) {
        return productService.getByCategory(category);
    }
    
    @ApiOperation(value = "Add a new product to the database.")
    @PostMapping("/products/add")
    public String saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    
    @ApiOperation(value = "Delete a specific product from the database by it's ID.")    
    @DeleteMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

    @ApiOperation(value = "Decrease a specific product's stock from the database by it's ID.")
    @PostMapping("/products/decreaseProduct/{id}/{OutboundStock}")
    public String getProductById (@PathVariable String id, Integer outboundStock) {
        return productService.getProductById(id, outboundStock);
    }


}