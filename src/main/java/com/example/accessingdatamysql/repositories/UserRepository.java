package com.example.accessingdatamysql.repositories;


import java.util.Optional;

import com.example.accessingdatamysql.models.User;
import org.springframework.data.repository.CrudRepository;

// Generic type required for CrudRepository => CrudRepository<T,ID>
public interface UserRepository extends CrudRepository<User,Integer>{ // Implements all CRUD useful operations 
    public abstract Optional<User> findById(Integer id); // We can find by all our fields (attributes defined in Model)
}
