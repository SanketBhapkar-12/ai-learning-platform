package ai_learning_platform.service;

import ai_learning_platform.dto.QuizAttemptRequest;
import ai_learning_platform.model.QuestionAnswer;
import ai_learning_platform.model.Quiz;
import ai_learning_platform.model.QuizAttempt;
import ai_learning_platform.model.QuizQuestion;
import ai_learning_platform.repository.QuizAttemptRepository;
import ai_learning_platform.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizAttemptService {

    private final QuizAttemptRepository quizAttemptRepository;
    private final QuizRepository quizRepository;

    public QuizAttemptService(
            QuizAttemptRepository quizAttemptRepository,
            QuizRepository quizRepository) {

        this.quizAttemptRepository = quizAttemptRepository;
        this.quizRepository = quizRepository;
    }

    public QuizAttempt evaluateAndSaveAttempt(
            QuizAttemptRequest request) {

        Quiz quiz = quizRepository.findById(request.getQuizId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Quiz not found: " + request.getQuizId()
                        ));

        int correctAnswers = 0;

        for (QuestionAnswer submittedAnswer : request.getAnswers()) {

            for (QuizQuestion question : quiz.getQuestions()) {

                if (question.getId().equals(
                        submittedAnswer.getQuestionId())) {

                    if (question.getCorrectAnswer().equals(
                            submittedAnswer.getSelectedAnswer())) {

                        correctAnswers++;
                    }

                    break;
                }
            }
        }

        int totalQuestions = quiz.getQuestions().size();

        double score = totalQuestions == 0
                ? 0
                : ((double) correctAnswers / totalQuestions) * 100;

        QuizAttempt attempt = new QuizAttempt(
                request.getQuizId(),
                request.getLearnerId(),
                request.getAnswers(),
                score,
                LocalDateTime.now()
        );

        return quizAttemptRepository.save(attempt);
    }

    public List<QuizAttempt> getAttemptsByQuizId(String quizId) {
        return quizAttemptRepository.findByQuizId(quizId);
    }

    public List<QuizAttempt> getAttemptsByLearnerId(String learnerId) {
        return quizAttemptRepository.findByLearnerId(learnerId);
    }
}