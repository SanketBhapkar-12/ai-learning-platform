package ai_learning_platform.service;

import ai_learning_platform.dto.CourseDetailsResponse;
import ai_learning_platform.dto.LessonResponse;
import ai_learning_platform.dto.ModuleDetailsResponse;
import ai_learning_platform.model.Course;
import ai_learning_platform.model.Lesson;
import ai_learning_platform.model.Module;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDetailsService {

    private final CourseService courseService;
    private final ModuleService moduleService;
    private final LessonService lessonService;

    public CourseDetailsService(
            CourseService courseService,
            ModuleService moduleService,
            LessonService lessonService) {

        this.courseService = courseService;
        this.moduleService = moduleService;
        this.lessonService = lessonService;
    }

    public CourseDetailsResponse getCourseDetails(String courseId) {

        Course course = courseService.getCourseById(courseId);

        List<ModuleDetailsResponse> modules =
                moduleService.getModulesByCourseId(courseId)
                        .stream()
                        .map(this::buildModuleDetails)
                        .toList();

        return new CourseDetailsResponse(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getTopic(),
                course.getDifficulty(),
                course.getDurationInDays(),
                modules
        );
    }

    private ModuleDetailsResponse buildModuleDetails(Module module) {

        List<LessonResponse> lessons =
                lessonService.getLessonsByModuleId(module.getId())
                        .stream()
                        .map(this::convertLessonToResponse)
                        .toList();

        return new ModuleDetailsResponse(
                module.getId(),
                module.getTitle(),
                module.getDescription(),
                module.getOrder(),
                lessons
        );
    }

    private LessonResponse convertLessonToResponse(Lesson lesson) {

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