package ai_learning_platform.repository;

import ai_learning_platform.model.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProgressRepository
        extends MongoRepository<Progress, String> {

    Optional<Progress> findByLearnerIdAndLessonId(
            String learnerId,
            String lessonId
    );
}