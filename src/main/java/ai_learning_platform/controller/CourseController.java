package ai_learning_platform.controller;

import ai_learning_platform.dto.CourseRequest;
import ai_learning_platform.dto.CourseResponse;
import ai_learning_platform.model.Course;
import ai_learning_platform.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponse createCourse(
            @Valid @RequestBody CourseRequest request) {

        Course course = new Course(
                request.getTitle(),
                request.getDescription(),
                request.getTopic(),
                request.getDifficulty(),
                request.getDurationInDays()
        );

        Course savedCourse = courseService.createCourse(course);

        return convertToResponse(savedCourse);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses() {

        return courseService.getAllCourses()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    private CourseResponse convertToResponse(Course course) {

        return new CourseResponse(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getTopic(),
                course.getDifficulty(),
                course.getDurationInDays()
        );
    }
}