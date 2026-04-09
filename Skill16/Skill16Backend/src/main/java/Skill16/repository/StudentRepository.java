package Skill16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Skill16.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}