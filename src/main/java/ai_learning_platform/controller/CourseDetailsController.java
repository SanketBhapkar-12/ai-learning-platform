package ai_learning_platform.controller;

import ai_learning_platform.dto.CourseDetailsResponse;
import ai_learning_platform.service.CourseDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-details")
public class CourseDetailsController {

    private final CourseDetailsService courseDetailsService;

    public CourseDetailsController(
            CourseDetailsService courseDetailsService) {

        this.courseDetailsService = courseDetailsService;
    }

    @GetMapping("/{courseId}")
    public CourseDetailsResponse getCourseDetails(
            @PathVariable String courseId) {

        return courseDetailsService.getCourseDetails(courseId);
    }
}