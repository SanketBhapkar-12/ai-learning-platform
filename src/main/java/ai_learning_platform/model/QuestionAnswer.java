package ai_learning_platform.model;

public class QuestionAnswer {

    private String questionId;
    private String selectedAnswer;

    public QuestionAnswer() {
    }

    public QuestionAnswer(String questionId, String selectedAnswer) {
        this.questionId = questionId;
        this.selectedAnswer = selectedAnswer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
