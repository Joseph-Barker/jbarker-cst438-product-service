//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.UserRepository;

//Remember to annotate what type of class this is!
@Service
public class UserService
{
    //We need to autowire the database here.
    @Autowired
    UserRepository userRepository;


    public Iterable<User> getAll () {
        Iterable<User> result = userRepository.findAll();
        return result;
    }

    public User getUserByEmail (String email) {
        email = email.toLowerCase();
        User result = userRepository.findByRepoId(email);
        return result;
    }

    public String saveUser(User user){
        if (userRepository.findByRepoId(user.getEmail().toLowerCase()) != null) {
            return "User email: " + user.getEmail().toLowerCase() + " already in use";
        }
        user.setEmail(user.getEmail().toLowerCase());
        userRepository.save(user);
        return "Added user with email: " + user.getEmail();
    }


    public String deleteUser(String email) {
        email = email.toLowerCase();
        userRepository.deleteById(email);
        return "Deleted user with email: " + email;
    }    

    public String authenticateUser (String email, String password) {
        email = email.toLowerCase();
        User user = userRepository.findByRepoId(email);
        if (user == null) {
            return "No user with email: " + email;    
        }
        if (user.getPassword().equals(password)) {
            return "Authenticate user";
        }
        
        return "Incorrect password for email: " + user.getEmail();
    }    

}