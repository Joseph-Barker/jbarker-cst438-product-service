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
import edu.csumb.cst438.productdb.repositores.IProductRepository;

@RestController
public class ProductController {
    @Autowired
    IProductRepository productRepository;

    @GetMapping ("/products/getAll")
    public List<Product> getAll () {
        List<Product> result = productRepository.findAll();
        return result;
    }
    	
    @GetMapping("/products/get/{id}")
    public Product getProductById (@PathVariable String id) {
        Product result = productRepository.findByRepoId(id);
        return result;
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getByCategory (@PathVariable String category) {
        List<Product> result = productRepository.findByCategory(category);
        return result;
    }

    @PostMapping("/products/add")
    public String saveProduct(@RequestBody Product product){
        productRepository.save(product);
        return "Added product with id: " + product.getId();
    }
    
    @DeleteMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
        return "Product deleted with id: " + id;
    }

}