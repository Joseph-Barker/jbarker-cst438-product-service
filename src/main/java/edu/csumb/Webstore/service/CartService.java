package edu.csumb.Webstore.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.repositories.ProductRepository;
import edu.csumb.Webstore.repositories.UserRepository;
import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.model.User;

@Service
public class CartService
{
    //We need to autowire the databases here.
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    public HashMap<String, Integer> getCart(String email) {
        email = email.toLowerCase();
        User result = userRepository.findByRepoId(email);
        if (result != null) {
            return result.getCart();
        }
        return null;
    }

    public String updateQuantity(String id, Integer proposedQuant, User user, String email) {
        email = email.toLowerCase();
        if (proposedQuant > 0) {
            user.updateQuantity(id, proposedQuant);
            userRepository.save(user);
        } else {
            user.removeProductFromCart(id);
            userRepository.save(user);
            return "The product: " + id + " was removed from user: " + email;
        }
        return "The user " + email + " quantity of " + id + " was adjusted to " + proposedQuant;        
    }

    public String addProductToCart(String email, String id, Integer quantity) {
        email = email.toLowerCase();
        if (productRepository.findByRepoId(id) == null){
            return "The product: " + id + " doesn’t exist in the product database.";
        }
        if (userRepository.findByRepoId(email) == null) {
            return "The user: " + email + " doesn’t exist in the user database.";
        }
        
        User user = userRepository.findByRepoId(email);
        HashMap<String, Integer> cart = getCart(email);
        Integer proposedQuant = cart.getOrDefault(id, 0) + quantity;
        return updateQuantity(id, proposedQuant, user, email);
    }

    public String changeQuantity(String email, String id, Integer quantity) {
        email = email.toLowerCase();
        User user = userRepository.findByRepoId(email);
        if (user == null) {
            return "The user: " + email + " doesn’t exist in the user database.";
        }        
        
        HashMap<String, Integer> cart = getCart(email);
        if (cart.get(id) == null) {
            return "User " + email + " doesn’t have product id: " + id + " in cart";
        }
        return updateQuantity(id, quantity, user, email);
    }

    public String checkout(String email) {
        email = email.toLowerCase();
        User user = userRepository.findByRepoId(email);
        HashMap<String, Integer> cart = getCart(email);
        
        if (user == null) {
            return "The user: " + email + " doesn’t exist in the user database.";
        } 

        for (HashMap.Entry<String,Integer> entry : cart.entrySet()){
            Product product = productRepository.findByRepoId(entry.getKey());
            if (product != null) {
                product.decreaseStock(entry.getValue());
                productRepository.save(product);
            }
        }
        user.getCart().clear();
        userRepository.save(user);
        return "User with email " + email + " has checked out";
    }

}