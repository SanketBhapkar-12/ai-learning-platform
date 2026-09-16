package ai_learning_platform.dto;

public class CourseResponse {

    private String id;
    private String title;
    private String description;
    private String topic;
    private String difficulty;
    private int durationInDays;

    public CourseResponse() {
    }

    public CourseResponse(String id,
                          String title,
                          String description,
                          String topic,
                          String difficulty,
                          int durationInDays) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.difficulty = difficulty;
        this.durationInDays = durationInDays;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTopic() {
        return topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }
}