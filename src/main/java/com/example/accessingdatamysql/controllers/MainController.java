package com.example.accessingdatamysql.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.accessingdatamysql.models.Student;
import com.example.accessingdatamysql.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller // This means that this class is a controller
@RequestMapping(path = "/students") // This means URL's start with /students after app path
public class MainController {
    @Autowired // Allows us to use a service without instantiating it
    private StudentService studentService; // We sill make our CRUD operations via our studentService. In this case is something very simple but it could have any kind of complicated logic inside 
    
    @PostMapping
    public @ResponseBody Student addNewStudent(@RequestBody Student student) {
        // @ResponseBody means the returned Student is the response and not a view name
        return studentService.addStudent(student);
    }

    @GetMapping
    public @ResponseBody ArrayList<Student> getAllStudents() {
        // This will return an array of JSON or XML with all students
        return studentService.getStudents();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Student> getStudentById(@PathVariable Integer id) {
        // This will return either the students found or null if search doesn't resolve well
        return studentService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteStudentById(@PathVariable Integer id){
        boolean deleteQueryOk = studentService.deleteStudent(id);
        if(deleteQueryOk){
            return "Student with id \"" + id + "\" successfully deleted";
        }

        return "Something went wrong";
    }

}
