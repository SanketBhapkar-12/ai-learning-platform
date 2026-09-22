package ai_learning_platform.dto;

public class RecommendedLesson {

    private String lessonId;
    private String title;
    private String topic;
    private int estimatedMinutes;
    private double topicAccuracy;
    private String reason;

    public RecommendedLesson() {
    }

    public RecommendedLesson(
            String lessonId,
            String title,
            String topic,
            int estimatedMinutes,
            double topicAccuracy,
            String reason) {

        this.lessonId = lessonId;
        this.title = title;
        this.topic = topic;
        this.estimatedMinutes = estimatedMinutes;
        this.topicAccuracy = topicAccuracy;
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

    public void setReason(String reason) {
        this.reason = reason;
    }
}