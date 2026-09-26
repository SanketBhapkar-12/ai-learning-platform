package ai_learning_platform.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "progress")
public class Progress {

    @Id
    private String id;

    private String learnerId;
    private String courseId;
    private String moduleId;
    private String lessonId;

    private ProgressStatus status;

    private int progressPercentage;
    private int timeSpentMinutes;

    private LocalDateTime completedAt;

    public Progress() {
    }

    public Progress(
            String learnerId,
            String courseId,
            String moduleId,
            String lessonId,
            ProgressStatus status,
            int progressPercentage,
            int timeSpentMinutes,
            LocalDateTime completedAt) {

        this.learnerId = learnerId;
        this.courseId = courseId;
        this.moduleId = moduleId;
        this.lessonId = lessonId;
        this.status = status;
        this.progressPercentage = progressPercentage;
        this.timeSpentMinutes = timeSpentMinutes;
        this.completedAt = completedAt;
    }

    public String getId() {
        return id;
    }

    public String getLearnerId() {
        return learnerId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public ProgressStatus getStatus() {
        return status;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public int getTimeSpentMinutes() {
        return timeSpentMinutes;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLearnerId(String learnerId) {
        this.learnerId = learnerId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public void setStatus(ProgressStatus status) {
        this.status = status;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public void setTimeSpentMinutes(int timeSpentMinutes) {
        this.timeSpentMinutes = timeSpentMinutes;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}