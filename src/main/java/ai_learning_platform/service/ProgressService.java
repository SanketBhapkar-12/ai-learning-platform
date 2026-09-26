package ai_learning_platform.service;

import ai_learning_platform.dto.ProgressRequest;
import ai_learning_platform.dto.ProgressResponse;
import ai_learning_platform.model.Progress;
import ai_learning_platform.model.ProgressStatus;
import ai_learning_platform.repository.LessonRepository;
import ai_learning_platform.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProgressService {

    private final ProgressRepository progressRepository;
    private final LessonRepository lessonRepository;

    public ProgressService(
            ProgressRepository progressRepository,
            LessonRepository lessonRepository) {

        this.progressRepository = progressRepository;
        this.lessonRepository = lessonRepository;
    }

    public ProgressResponse saveProgress(ProgressRequest request) {

        // Step 1: Make sure the lesson exists
        if (!lessonRepository.existsById(request.getLessonId())) {
            throw new RuntimeException(
                    "Lesson not found: " + request.getLessonId()
            );
        }

        // Step 2: Check whether progress already exists
        Optional<Progress> existingProgress =
                progressRepository.findByLearnerIdAndLessonId(
                        request.getLearnerId(),
                        request.getLessonId()
                );

        Progress progress;

        if (existingProgress.isPresent()) {

            // Existing progress → update it
            progress = existingProgress.get();

        } else {

            // No progress yet → create new record
            progress = new Progress();
            progress.setLearnerId(request.getLearnerId());
            progress.setCourseId(request.getCourseId());
            progress.setModuleId(request.getModuleId());
            progress.setLessonId(request.getLessonId());
        }

        // Step 3: Business validation
        if (request.getStatus() == ProgressStatus.COMPLETED
                && request.getProgressPercentage() != 100) {

            throw new IllegalArgumentException(
                    "Completed lessons must have 100% progress."
            );
        }

        // Step 4: Update progress information
        progress.setStatus(request.getStatus());
        progress.setProgressPercentage(
                request.getProgressPercentage()
        );
        progress.setTimeSpentMinutes(
                request.getTimeSpentMinutes()
        );

        // Step 5: Handle completion timestamp
        if (request.getStatus() == ProgressStatus.COMPLETED) {

            if (progress.getCompletedAt() == null) {
                progress.setCompletedAt(LocalDateTime.now());
            }

        } else {

            progress.setCompletedAt(null);
        }

        // Step 6: Save to MongoDB
        Progress savedProgress =
                progressRepository.save(progress);

        // Step 7: Convert model to response DTO
        return convertToResponse(savedProgress);
    }

    private ProgressResponse convertToResponse(
            Progress progress) {

        return new ProgressResponse(
                progress.getId(),
                progress.getLearnerId(),
                progress.getCourseId(),
                progress.getModuleId(),
                progress.getLessonId(),
                progress.getStatus(),
                progress.getProgressPercentage(),
                progress.getTimeSpentMinutes(),
                progress.getCompletedAt()
        );
    }
}