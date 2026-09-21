package ai_learning_platform.model;

import java.util.List;

public class QuizQuestion {

    private String id;
    private String questionText;
    private List<String> options;
    private String correctAnswer;
    private String explanation;

    public QuizQuestion() {
    }

    public QuizQuestion(
            String id,
            String questionText,
            List<String> options,
            String correctAnswer,
            String explanation) {

        this.id = id;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }

    public String getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}