package ai_learning_platform.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "quiz_attempts")
public class QuizAttempt {

    @Id
    private String id;

    private String quizId;
    private String learnerId;
    private List<QuestionAnswer> answers;
    private double score;
    private LocalDateTime submittedAt;

    public QuizAttempt() {
    }

    public QuizAttempt(
            String quizId,
            String learnerId,
            List<QuestionAnswer> answers,
            double score,
            LocalDateTime submittedAt) {

        this.quizId = quizId;
        this.learnerId = learnerId;
        this.answers = answers;
        this.score = score;
        this.submittedAt = submittedAt;
    }

    public String getId() {
        return id;
    }

    public String getQuizId() {
        return quizId;
    }

    public String getLearnerId() {
        return learnerId;
    }

    public List<QuestionAnswer> getAnswers() {
        return answers;
    }

    public double getScore() {
        return score;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public void setLearnerId(String learnerId) {
        this.learnerId = learnerId;
    }

    public void setAnswers(List<QuestionAnswer> answers) {
        this.answers = answers;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}