package ai_learning_platform.dto;

public class LessonResponse {

    private String id;
    private String moduleId;
    private String title;
    private String content;
    private int order;
    private int estimatedMinutes;

    public LessonResponse() {
    }

    public LessonResponse(String id,
                          String moduleId,
                          String title,
                          String content,
                          int order,
                          int estimatedMinutes) {

        this.id = id;
        this.moduleId = moduleId;
        this.title = title;
        this.content = content;
        this.order = order;
        this.estimatedMinutes = estimatedMinutes;
    }

    public String getId() {
        return id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getOrder() {
        return order;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }
}