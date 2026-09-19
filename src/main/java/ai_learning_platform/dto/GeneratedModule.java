package ai_learning_platform.dto;

import java.util.List;

public class GeneratedModule {

    private String title;
    private String description;
    private int order;
    private List<GeneratedLesson> lessons;

    public GeneratedModule() {
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<GeneratedLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<GeneratedLesson> lessons) {
        this.lessons = lessons;
    }
}