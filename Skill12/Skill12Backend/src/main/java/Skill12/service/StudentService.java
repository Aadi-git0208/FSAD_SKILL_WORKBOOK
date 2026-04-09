package Skill12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import Skill12.model.Student;
import Skill12.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student save(Student s) {
        return repo.save(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student update(Long id, Student s) {
        Student old = repo.findById(id).orElse(null);
        old.setName(s.getName());
        old.setEmail(s.getEmail());
        old.setCourse(s.getCourse());
        return repo.save(old);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}