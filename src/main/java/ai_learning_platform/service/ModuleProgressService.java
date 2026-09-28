package ai_learning_platform.service;

import ai_learning_platform.dto.ModuleProgressResponse;
import ai_learning_platform.model.Lesson;
import ai_learning_platform.model.Progress;
import ai_learning_platform.model.ProgressStatus;
import ai_learning_platform.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleProgressService {

    private final LessonService lessonService;
    private final ProgressRepository progressRepository;

    public ModuleProgressService(
            LessonService lessonService,
            ProgressRepository progressRepository) {

        this.lessonService = lessonService;
        this.progressRepository = progressRepository;
    }

    public ModuleProgressResponse getModuleProgress(
            String learnerId,
            String moduleId) {

        // Step 1: Find all lessons in the module
        List<Lesson> lessons =
                lessonService.getLessonsByModuleId(moduleId);

        // Step 2: Count total lessons
        int totalLessons = lessons.size();

        // Step 3: Count completed lessons
        int completedLessons = 0;

        for (Lesson lesson : lessons) {

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

        // Step 4: Calculate percentage
        double progressPercentage =
                totalLessons == 0
                        ? 0
                        : ((double) completedLessons
                        / totalLessons) * 100;

        // Step 5: Round to two decimal places
        progressPercentage =
                Math.round(progressPercentage * 100.0) / 100.0;

        // Step 6: Return response
        return new ModuleProgressResponse(
                moduleId,
                learnerId,
                totalLessons,
                completedLessons,
                progressPercentage
        );
    }
}