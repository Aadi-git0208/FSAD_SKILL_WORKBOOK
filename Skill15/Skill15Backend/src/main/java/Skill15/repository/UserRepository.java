package Skill15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Skill15.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}