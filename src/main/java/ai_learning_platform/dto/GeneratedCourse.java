package ai_learning_platform.dto;

import java.util.List;

public class GeneratedCourse {

    private String title;
    private String description;
    private String topic;
    private String difficulty;
    private int durationInDays;
    private List<GeneratedModule> modules;

    public GeneratedCourse() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<GeneratedModule> getModules() {
        return modules;
    }

    public void setModules(List<GeneratedModule> modules) {
        this.modules = modules;
    }
}