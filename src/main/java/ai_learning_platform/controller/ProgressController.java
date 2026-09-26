package ai_learning_platform.controller;

import ai_learning_platform.dto.CourseProgressResponse;
import ai_learning_platform.dto.ProgressRequest;
import ai_learning_platform.dto.ProgressResponse;
import ai_learning_platform.service.CourseProgressService;
import ai_learning_platform.service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;
    private final CourseProgressService courseProgressService;

    public ProgressController(
            ProgressService progressService,
            CourseProgressService courseProgressService) {

        this.progressService = progressService;
        this.courseProgressService = courseProgressService;
    }

    @PostMapping
    public ProgressResponse saveProgress(
            @Valid @RequestBody ProgressRequest request) {

        return progressService.saveProgress(request);
    }

    @GetMapping("/course/{learnerId}/{courseId}")
    public CourseProgressResponse getCourseProgress(
            @PathVariable String learnerId,
            @PathVariable String courseId) {

        return courseProgressService.getCourseProgress(
                learnerId,
                courseId
        );
    }
}