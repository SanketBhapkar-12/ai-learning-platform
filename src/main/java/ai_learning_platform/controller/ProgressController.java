package ai_learning_platform.controller;

import ai_learning_platform.dto.CourseProgressResponse;
import ai_learning_platform.dto.LearnerProgressResponse;
import ai_learning_platform.dto.ModuleProgressResponse;
import ai_learning_platform.dto.ProgressRequest;
import ai_learning_platform.dto.ProgressResponse;
import ai_learning_platform.service.CourseProgressService;
import ai_learning_platform.service.LearnerProgressService;
import ai_learning_platform.service.ModuleProgressService;
import ai_learning_platform.service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;
    private final CourseProgressService courseProgressService;
    private final ModuleProgressService moduleProgressService;
    private final LearnerProgressService learnerProgressService;

    public ProgressController(
            ProgressService progressService,
            CourseProgressService courseProgressService,
            ModuleProgressService moduleProgressService,
            LearnerProgressService learnerProgressService) {

        this.progressService = progressService;
        this.courseProgressService = courseProgressService;
        this.moduleProgressService = moduleProgressService;
        this.learnerProgressService = learnerProgressService;
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

    @GetMapping("/module/{learnerId}/{moduleId}")
    public ModuleProgressResponse getModuleProgress(
            @PathVariable String learnerId,
            @PathVariable String moduleId) {

        return moduleProgressService.getModuleProgress(
                learnerId,
                moduleId
        );
    }

    @GetMapping("/dashboard/{learnerId}/{courseId}")
    public LearnerProgressResponse getLearnerProgress(
            @PathVariable String learnerId,
            @PathVariable String courseId) {

        return learnerProgressService.getLearnerProgress(
                learnerId,
                courseId
        );
    }
}