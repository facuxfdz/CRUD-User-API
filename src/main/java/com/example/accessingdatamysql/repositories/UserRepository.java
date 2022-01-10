package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
    
}
