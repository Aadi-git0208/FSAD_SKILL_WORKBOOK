package Skill16.controller;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import Skill16.model.Student;
import Skill16.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    @Operation(summary = "Add a new student")
    @ApiResponse(responseCode = "200", description = "Student added successfully")
    public Student add(@RequestBody Student s) {
        return service.save(s);
    }

    @GetMapping
    @Operation(summary = "Get all students")
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID")
    public Student getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update student")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete student")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }
}