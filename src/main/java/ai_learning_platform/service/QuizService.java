package ai_learning_platform.service;

import ai_learning_platform.model.Quiz;
import ai_learning_platform.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizByLessonId(String lessonId) {
        return quizRepository.findByLessonId(lessonId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Quiz not found for lesson: " + lessonId
                        ));
    }
}
