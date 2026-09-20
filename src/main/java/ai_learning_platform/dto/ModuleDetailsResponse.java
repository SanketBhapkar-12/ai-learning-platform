package ai_learning_platform.dto;

import java.util.List;

public class ModuleDetailsResponse {

    private String id;
    private String title;
    private String description;
    private int order;
    private List<LessonResponse> lessons;

    public ModuleDetailsResponse() {
    }

    public ModuleDetailsResponse(
            String id,
            String title,
            String description,
            int order,
            List<LessonResponse> lessons) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.order = order;
        this.lessons = lessons;
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

    public int getOrder() {
        return order;
    }

    public List<LessonResponse> getLessons() {
        return lessons;
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

    public void setOrder(int order) {
        this.order = order;
    }

    public void setLessons(List<LessonResponse> lessons) {
        this.lessons = lessons;
    }
}