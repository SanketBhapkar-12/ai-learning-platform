package ai_learning_platform.controller;

import ai_learning_platform.dto.LessonRequest;
import ai_learning_platform.dto.LessonResponse;
import ai_learning_platform.model.Lesson;
import ai_learning_platform.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public LessonResponse createLesson(
            @Valid @RequestBody LessonRequest request) {

        Lesson lesson = new Lesson(
                request.getModuleId(),
                request.getTitle(),
                request.getContent(),
                request.getTopic(),
                request.getOrder(),
                request.getEstimatedMinutes()
        );

        Lesson savedLesson = lessonService.createLesson(lesson);

        return convertToResponse(savedLesson);
    }

    @GetMapping
    public List<LessonResponse> getAllLessons() {

        return lessonService.getAllLessons()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @GetMapping("/module/{moduleId}")
    public List<LessonResponse> getLessonsByModuleId(
            @PathVariable String moduleId) {

        return lessonService.getLessonsByModuleId(moduleId)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    @GetMapping("/topic/{topic}")
    public List<LessonResponse> getLessonsByTopic(
        @PathVariable String topic) {

        return lessonService.getLessonsByTopic(topic)
            .stream()
            .map(this::convertToResponse)
            .toList();
    }

    private LessonResponse convertToResponse(Lesson lesson) {

        return new LessonResponse(
                lesson.getId(),
                lesson.getModuleId(),
                lesson.getTitle(),
                lesson.getContent(),
                lesson.getTopic(),
                lesson.getOrder(),
                lesson.getEstimatedMinutes()
        );
    }
}