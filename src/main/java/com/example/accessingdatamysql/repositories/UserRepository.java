package com.example.accessingdatamysql.repositories;


import java.util.Optional;

import com.example.accessingdatamysql.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
    public abstract Optional<User> findById(Integer id);
}
