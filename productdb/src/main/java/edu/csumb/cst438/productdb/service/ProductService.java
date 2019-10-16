package edu.csumb.cst438.productdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.cst438.productdb.repositores.IProductRepository;

@Service
public class ProductService {
    @Autowired
    IProductRepository productRepository;


}
