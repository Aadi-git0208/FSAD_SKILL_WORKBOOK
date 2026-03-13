package com.university.courseapi.Service;
import java.util.*;
import org.springframework.stereotype.Service;
import com.university.courseapi.Model.Course;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courseList;
    }

    public Course getCourseById(int id) {
        return courseList.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public boolean updateCourse(int id, Course updatedCourse) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }
}