package ai_learning_platform.controller;

import ai_learning_platform.dto.QuizAttemptRequest;
import ai_learning_platform.model.QuizAttempt;
import ai_learning_platform.service.QuizAttemptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz-attempts")
public class QuizAttemptController {

    private final QuizAttemptService quizAttemptService;

    public QuizAttemptController(
            QuizAttemptService quizAttemptService) {

        this.quizAttemptService = quizAttemptService;
    }

    @PostMapping
    public QuizAttempt submitQuiz(
            @RequestBody QuizAttemptRequest request) {

        return quizAttemptService.evaluateAndSaveAttempt(request);
    }
}