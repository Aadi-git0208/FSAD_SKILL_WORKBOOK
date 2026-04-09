package Skill12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import Skill12.model.Student;
import Skill12.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/students")
    public ResponseEntity<Student> add(@RequestBody Student s) {
        return ResponseEntity.ok(service.save(s));
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student s) {
        return ResponseEntity.ok(service.update(id, s));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}