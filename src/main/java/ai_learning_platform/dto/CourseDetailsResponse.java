package ai_learning_platform.dto;

import java.util.List;

public class CourseDetailsResponse {

    private String id;
    private String title;
    private String description;
    private String topic;
    private String difficulty;
    private int durationInDays;
    private List<ModuleDetailsResponse> modules;

    public CourseDetailsResponse() {
    }

    public CourseDetailsResponse(
            String id,
            String title,
            String description,
            String topic,
            String difficulty,
            int durationInDays,
            List<ModuleDetailsResponse> modules) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.difficulty = difficulty;
        this.durationInDays = durationInDays;
        this.modules = modules;
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

    public List<ModuleDetailsResponse> getModules() {
        return modules;
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

    public void setModules(List<ModuleDetailsResponse> modules) {
        this.modules = modules;
    }
}
