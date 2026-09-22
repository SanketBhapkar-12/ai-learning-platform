package ai_learning_platform.repository;

import ai_learning_platform.model.QuizAttempt;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizAttemptRepository
        extends MongoRepository<QuizAttempt, String> {

    List<QuizAttempt> findByQuizId(String quizId);

    List<QuizAttempt> findByLearnerId(String learnerId);
}