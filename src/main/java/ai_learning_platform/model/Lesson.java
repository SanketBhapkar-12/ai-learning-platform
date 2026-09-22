package ai_learning_platform.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lessons")
public class Lesson {

    @Id
    private String id;

    private String moduleId;
    private String title;
    private String content;
    private String topic;
    private int order;
    private int estimatedMinutes;

    public Lesson() {
    }

    public Lesson(
            String moduleId,
            String title,
            String content,
            String topic,
            int order,
            int estimatedMinutes) {

        this.moduleId = moduleId;
        this.title = title;
        this.content = content;
        this.topic = topic;
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

    public String getTopic() {
        return topic;
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

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }
}