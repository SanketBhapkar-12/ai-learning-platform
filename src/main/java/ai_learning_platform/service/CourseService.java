package ai_learning_platform.service;

import ai_learning_platform.model.Course;
import ai_learning_platform.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseById(String courseId) {
    return courseRepository.findById(courseId)
            .orElseThrow(() ->
                    new RuntimeException("Course not found: " + courseId));
    }
}