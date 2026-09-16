package ai_learning_platform.dto;

public class ModuleResponse {

    private String id;
    private String courseId;
    private String title;
    private String description;
    private int order;

    public ModuleResponse() {
    }

    public ModuleResponse(String id,
                          String courseId,
                          String title,
                          String description,
                          int order) {

        this.id = id;
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