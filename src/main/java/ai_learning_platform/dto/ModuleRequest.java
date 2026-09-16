package ai_learning_platform.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ModuleRequest {

    @NotBlank(message = "Course ID is required")
    private String courseId;

    @NotBlank(message = "Module title is required")
    private String title;

    @NotBlank(message = "Module description is required")
    private String description;

    @Min(value = 1, message = "Module order must be at least 1")
    private int order;

    public ModuleRequest() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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
}