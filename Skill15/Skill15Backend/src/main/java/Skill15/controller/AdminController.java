package Skill15.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/add")
    public String add() {
        return "Admin Added Data";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "Admin Deleted Data";
    }
}