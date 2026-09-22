package ai_learning_platform.dto;

public class TopicPerformance {

    private String topic;
    private int correctAnswers;
    private int totalQuestions;
    private double accuracy;

    public TopicPerformance() {
    }

    public TopicPerformance(
            String topic,
            int correctAnswers,
            int totalQuestions,
            double accuracy) {

        this.topic = topic;
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
        this.accuracy = accuracy;
    }

    public String getTopic() {
        return topic;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}