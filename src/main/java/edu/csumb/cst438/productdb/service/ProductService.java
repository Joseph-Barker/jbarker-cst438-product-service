package edu.csumb.cst438.productdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.cst438.productdb.repositores.IProductRepository;
import edu.csumb.cst438.productdb.model.Product;

@Service
public class ProductService {
    @Autowired
    IProductRepository productRepository;

    public List<Product> getAll () {
        List<Product> result = productRepository.findAll();
        return result;
    }

    public Product getProductById (String id) {
        Product result = productRepository.findByRepoId(id);
        return result;
    }

    public List<Product> getByCategory (String category) {
        List<Product> result = productRepository.findByCategory(category);
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

    public String getProductById (String id, Integer outboundStock) {
        Product product = productRepository.findByRepoId(id);
        product.decreaseStock(outboundStock);
        productRepository.save(product);
        return "Product with id: " + id + " was decrease by " + outboundStock;
    }
}
