package ai_learning_platform.controller;

import ai_learning_platform.dto.GeneratedCourse;
import ai_learning_platform.model.Course;
import ai_learning_platform.service.CoursePersistenceService;
import ai_learning_platform.service.MockCourseAIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mock/courses")
public class MockCourseController {

    private final MockCourseAIService mockCourseAIService;
    private final CoursePersistenceService coursePersistenceService;

    public MockCourseController(
            MockCourseAIService mockCourseAIService,
            CoursePersistenceService coursePersistenceService) {

        this.mockCourseAIService = mockCourseAIService;
        this.coursePersistenceService = coursePersistenceService;
    }

    @PostMapping("/generate")
    public Course generateCourse(
            @RequestParam String topic,
            @RequestParam String difficulty,
            @RequestParam int durationInDays) {

        GeneratedCourse generatedCourse =
                mockCourseAIService.generateCourse(
                        topic,
                        difficulty,
                        durationInDays
                );

        return coursePersistenceService
                .saveGeneratedCourse(generatedCourse);
    }
}