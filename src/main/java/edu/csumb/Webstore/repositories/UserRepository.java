//Every Java file should start with what package it's in! This ussually means a folder.
package edu.csumb.Webstore.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import edu.csumb.Webstore.model.User;

//Remember to denote what type of folder it is!
@Repository
//Setting up our database to be a MongoDB with Key's that are products, and values that are strings.
public interface UserRepository extends MongoRepository<User,String>
{

    //Will largely stay empty. You can add extra database features here if you want!
    @Query (value = "{'email':?0}")   
    User findByRepoId(String email);
}