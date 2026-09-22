package ai_learning_platform.dto;

import ai_learning_platform.model.QuestionAnswer;

import java.util.List;

public class QuizAttemptRequest {

    private String quizId;
    private String learnerId;
    private List<QuestionAnswer> answers;

    public QuizAttemptRequest() {
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

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public void setLearnerId(String learnerId) {
        this.learnerId = learnerId;
    }

    public void setAnswers(List<QuestionAnswer> answers) {
        this.answers = answers;
    }
}