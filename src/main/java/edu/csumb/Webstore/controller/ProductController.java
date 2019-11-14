//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    ProductService productService;

    @ApiOperation(value = "Get all products from the database.")
    @GetMapping ("/products/getAll")
    public Iterable<Product> getAll () {
        return productService.getAll();
    }
    
    @ApiOperation(value = "Get a specific product from the database by it's ID.")
    @GetMapping("/products/get/{id}")
    public Product getProductById (@PathVariable String id) {
        return productService.getProductById(id);
    }

    @ApiOperation(value = "Get all products of a specific category.")
    @GetMapping("/products/category/{category}")
    public Iterable<Product> getByCategory (@PathVariable String category) {
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
    @PostMapping("/products/decreaseProduct/{id}/{outboundStock}")
    public String getProductById (@PathVariable String id, Integer outboundStock) {
        return productService.decreaseProductById(id, outboundStock);
    }

    
}