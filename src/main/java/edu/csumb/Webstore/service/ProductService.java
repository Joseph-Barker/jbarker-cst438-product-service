//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;

//Remember to annotate what type of class this is!
@Service
public class ProductService
{
    //We need to autowire the database here.
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getAll () {
        List<Product> result = productRepository.findAll();
        return result;
    }

    public Product getProductById (String id) {
        Product result = productRepository.findByRepoId(id);
        return result;
    }

    public Iterable<Product> getByCategory (String category) {
        Iterable<Product> result = productRepository.findByCategory(category);
        return result;
    }

    public String saveProduct(Product product){
        productRepository.save(product);
        return "Added product with id: " + product.getId();
    }

    public String deleteProduct(String id) {
        productRepository.deleteById(id);
        return "Product deleted with id: " + id;
    }

    public String decreaseProductById (String id, Integer outboundStock) {
        Product product = productRepository.findByRepoId(id);
        product.decreaseStock(outboundStock);
        productRepository.save(product);
        return "Product with id: " + id + " was decrease by " + outboundStock;
    }
}