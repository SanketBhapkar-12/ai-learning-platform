package ai_learning_platform.controller;

import ai_learning_platform.dto.CourseGenerationRequest;
import ai_learning_platform.dto.GeneratedCourse;
import ai_learning_platform.model.Course;
import ai_learning_platform.service.CourseAIService;
import ai_learning_platform.service.CoursePersistenceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai/courses")
public class CourseAIController {

    private final CourseAIService courseAIService;
    private final CoursePersistenceService coursePersistenceService;

    public CourseAIController(
            CourseAIService courseAIService,
            CoursePersistenceService coursePersistenceService) {

        this.courseAIService = courseAIService;
        this.coursePersistenceService = coursePersistenceService;
    }

    @PostMapping("/generate")
    public Course generateCourse(
            @Valid @RequestBody CourseGenerationRequest request) {

        GeneratedCourse generatedCourse =
                courseAIService.generateCourse(request);

        return coursePersistenceService
                .saveGeneratedCourse(generatedCourse);
    }
}