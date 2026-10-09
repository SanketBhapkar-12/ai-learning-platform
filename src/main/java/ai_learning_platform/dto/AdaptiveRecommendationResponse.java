package ai_learning_platform.dto;

public class AdaptiveRecommendationResponse {

    private String lessonId;
    private String title;
    private String topic;
    private int estimatedMinutes;

    private double topicAccuracy;

    private String priority;
    private double recommendationScore;

    private String reason;

    public AdaptiveRecommendationResponse() {}

    public AdaptiveRecommendationResponse(
            String lessonId,
            String title,
            String topic,
            int estimatedMinutes,
            double topicAccuracy,
            String priority,
            double recommendationScore,
            String reason) {

        this.lessonId = lessonId;
        this.title = title;
        this.topic = topic;
        this.estimatedMinutes = estimatedMinutes;
        this.topicAccuracy = topicAccuracy;
        this.priority = priority;
        this.recommendationScore = recommendationScore;
        this.reason = reason;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public double getTopicAccuracy() {
        return topicAccuracy;
    }

    public String getPriority() {
        return priority;
    }

    public double getRecommendationScore() {
        return recommendationScore;
    }

    public String getReason() {
        return reason;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }

    public void setTopicAccuracy(double topicAccuracy) {
        this.topicAccuracy = topicAccuracy;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setRecommendationScore(double recommendationScore) {
        this.recommendationScore = recommendationScore;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}