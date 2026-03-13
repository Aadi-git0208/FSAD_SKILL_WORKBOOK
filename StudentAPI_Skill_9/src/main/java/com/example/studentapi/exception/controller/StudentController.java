package com.example.studentapi.exception.controller;

import com.example.studentapi.exception.exception.InvalidInputException;
import com.example.studentapi.exception.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public String getStudent(@PathVariable String id) {

        if(!id.matches("\\d+")){
            throw new InvalidInputException("Student ID must be numeric");
        }

        int studentId = Integer.parseInt(id);

        if(studentId != 1){
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }

        return "Student Found: Aditya";
    }
}