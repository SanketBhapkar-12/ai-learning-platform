package ai_learning_platform.dto;

import ai_learning_platform.model.ProgressStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProgressRequest {

    @NotBlank(message = "Learner ID is required")
    private String learnerId;

    @NotBlank(message = "Course ID is required")
    private String courseId;

    @NotBlank(message = "Module ID is required")
    private String moduleId;

    @NotBlank(message = "Lesson ID is required")
    private String lessonId;

    @NotNull(message = "Progress status is required")
    private ProgressStatus status;

    @Min(value = 0, message = "Progress percentage cannot be negative")
    @Max(value = 100, message = "Progress percentage cannot exceed 100")
    private int progressPercentage;

    @Min(value = 0, message = "Time spent cannot be negative")
    private int timeSpentMinutes;

    public ProgressRequest() {
    }

    public String getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(String learnerId) {
        this.learnerId = learnerId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public ProgressStatus getStatus() {
        return status;
    }

    public void setStatus(ProgressStatus status) {
        this.status = status;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public int getTimeSpentMinutes() {
        return timeSpentMinutes;
    }

    public void setTimeSpentMinutes(int timeSpentMinutes) {
        this.timeSpentMinutes = timeSpentMinutes;
    }
}