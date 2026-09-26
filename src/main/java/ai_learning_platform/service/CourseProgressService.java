package ai_learning_platform.service;

import ai_learning_platform.dto.CourseProgressResponse;
import ai_learning_platform.model.Lesson;
import ai_learning_platform.model.Module;
import ai_learning_platform.model.Progress;
import ai_learning_platform.model.ProgressStatus;
import ai_learning_platform.repository.ModuleRepository;
import ai_learning_platform.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseProgressService {

    private final ModuleRepository moduleRepository;
    private final LessonService lessonService;
    private final ProgressRepository progressRepository;

    public CourseProgressService(
            ModuleRepository moduleRepository,
            LessonService lessonService,
            ProgressRepository progressRepository) {

        this.moduleRepository = moduleRepository;
        this.lessonService = lessonService;
        this.progressRepository = progressRepository;
    }

    public CourseProgressResponse getCourseProgress(
            String learnerId,
            String courseId) {

        // Step 1: Find all modules belonging to the course
        List<Module> modules =
                moduleRepository.findByCourseId(courseId);

        List<Lesson> allLessons = new ArrayList<>();

        // Step 2: Find all lessons inside those modules
        for (Module module : modules) {

            List<Lesson> lessons =
                    lessonService.getLessonsByModuleId(
                            module.getId()
                    );

            allLessons.addAll(lessons);
        }

        // Step 3: Count total lessons
        int totalLessons = allLessons.size();

        // Step 4: Count completed lessons
        int completedLessons = 0;

        for (Lesson lesson : allLessons) {

            Progress progress =
                    progressRepository
                            .findByLearnerIdAndLessonId(
                                    learnerId,
                                    lesson.getId()
                            )
                            .orElse(null);

            if (progress != null
                    && progress.getStatus()
                    == ProgressStatus.COMPLETED) {

                completedLessons++;
            }
        }

        // Step 5: Calculate percentage
        double progressPercentage =
        totalLessons == 0
                ? 0
                : ((double) completedLessons
                / totalLessons) * 100;

progressPercentage =
        Math.round(progressPercentage * 100.0) / 100.0;
        // Step 6: Return response
        return new CourseProgressResponse(
                courseId,
                learnerId,
                totalLessons,
                completedLessons,
                progressPercentage
        );
    }
}