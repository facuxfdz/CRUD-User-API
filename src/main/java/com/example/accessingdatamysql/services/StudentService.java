package com.example.accessingdatamysql.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.accessingdatamysql.models.Student;
import com.example.accessingdatamysql.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // This class will be a service. It means a class with all business logic separated from @RestController class file
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student newStudentt) {
        return studentRepository.save(newStudentt); // Save method update the DB if primary key is provided. That's why its name is save() and not create()
    }

    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) studentRepository.findAll(); // It returns a Iterable<Student> so we cast it to ArrayList<Student>
    }

    public Optional<Student> getById(Integer id){ // It could not find anything so the return type should be Optional<Student>
        return studentRepository.findById(id);
    }

    public boolean deleteStudent(Integer id){ // This is a design decision. DeleteById throws an error if fails so we better return a boolean
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
