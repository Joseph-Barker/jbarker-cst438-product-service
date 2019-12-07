package edu.csumb.Webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.service.UserService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    UserService userService;

    @ApiOperation(value = "Get all users from the database.")
    @GetMapping ("/user/getAll")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @ApiOperation(value = "Get a specific user from the database by their email.")
    @GetMapping("/user/get/{email}")
    public User getUserByEmail (@PathVariable String email) {
        return userService.getUserByEmail(email);
    }    

    @ApiOperation(value = "Add a new user to the database.")
    @PostMapping("/user/add")
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @ApiOperation(value = "Delete a specific user from the database by their email.")    
    @DeleteMapping("/user/delete/{email}")
    public String deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }

    @ApiOperation(value = "Authenticate user credentials.")
    @GetMapping("/user/authenticate/{email}/{password}")
    public String authenticateUser(@PathVariable String email, String password){
        return userService.authenticateUser(email, password);
    }
}