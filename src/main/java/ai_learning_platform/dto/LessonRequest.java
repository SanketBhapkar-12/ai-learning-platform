package ai_learning_platform.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class LessonRequest {

    @NotBlank(message = "Module ID is required")
    private String moduleId;

    @NotBlank(message = "Lesson title is required")
    private String title;

    @NotBlank(message = "Lesson content is required")
    private String content;

    @Min(value = 1, message = "Lesson order must be at least 1")
    private int order;

    @Min(value = 1, message = "Estimated minutes must be at least 1")
    private int estimatedMinutes;

    public LessonRequest() {
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }
}