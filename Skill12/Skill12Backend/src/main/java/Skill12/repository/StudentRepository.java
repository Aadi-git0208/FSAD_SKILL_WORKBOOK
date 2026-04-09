package Skill12.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Skill12.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}