package edu.csumb.cst438.productdb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.csumb.cst438.productdb.model.Product;
import edu.csumb.cst438.productdb.repositores.IProductRepository;

@RestController
public class ProductController {
    @Autowired
    IProductRepository productRepository;

    @GetMapping ("/allProducts")
    public List<Product> getAll () {
        List<Product> result = productRepository.findAll();
        return result;
    }
    	
    @GetMapping("/id/{id}")
    public Product getProductById (@PathVariable String id) {
        Product result = productRepository.findByRepoId(id);
        return result;
    }

    @GetMapping("/power/{power}")
    public List<Product> getByPower (@PathVariable String power) {
        List<Product> result = productRepository.findByPower(power);
        return result;
    }

    @GetMapping("/someData")
    public String getThirdPartyData (){
        RestTemplate myTemplate = new RestTemplate();
        String resourceUrl = "https://reqres.in/api/users";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        ResponseEntity<String> response = myTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        return response.getBody();
        //return "hello"; 
    }
	
}