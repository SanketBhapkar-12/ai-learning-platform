package ai_learning_platform.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "modules")
public class Module {

    @Id
    private String id;

    @NotBlank(message = "Course ID cannot be blank")
    private String courseId;
    @NotBlank(message = "Module title is required")
    private String title;
    @NotBlank (message = "Module description is required")
    private String description;
    @Min(value = 1, message = "Module order must be at least 1")
    private int order;

    public Module() {
    }

    public Module(String courseId,
                  String title,
                  String description,
                  int order) {

        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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
}