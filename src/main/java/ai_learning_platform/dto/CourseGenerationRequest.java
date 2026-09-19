package ai_learning_platform.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CourseGenerationRequest {

    @NotBlank(message = "Topic is required")
    private String topic;

    @NotBlank(message = "Difficulty is required")
    private String difficulty;

    @Min(value = 1, message = "Duration must be at least 1 day")
    private int durationInDays;

    public CourseGenerationRequest() {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }
}