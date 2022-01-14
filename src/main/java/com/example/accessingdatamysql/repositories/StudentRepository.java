package com.example.accessingdatamysql.repositories;


import java.util.Optional;

import com.example.accessingdatamysql.models.Student;
import org.springframework.data.repository.CrudRepository;

// Generic type required for CrudRepository => CrudRepository<T,ID>
public interface StudentRepository extends CrudRepository<Student,Integer>{ // Implements all CRUD useful operations 
    public abstract Optional<Student> findById(Integer id); // We can find by all our fields (attributes defined in Model)
}
