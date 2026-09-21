package ai_learning_platform.controller;

import ai_learning_platform.model.Quiz;
import ai_learning_platform.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/lesson/{lessonId}")
    public Quiz getQuizByLessonId(
            @PathVariable String lessonId) {

        return quizService.getQuizByLessonId(lessonId);
    }
}