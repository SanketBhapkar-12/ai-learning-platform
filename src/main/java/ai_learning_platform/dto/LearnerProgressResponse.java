package ai_learning_platform.dto;

import java.util.List;

public class LearnerProgressResponse {

    private String courseId;
    private String learnerId;

    private int totalLessons;
    private int completedLessons;
    private double progressPercentage;

    private List<ModuleProgressResponse> modules;

    public LearnerProgressResponse() {}

    public LearnerProgressResponse(
            String courseId,
            String learnerId,
            int totalLessons,
            int completedLessons,
            double progressPercentage,
            List<ModuleProgressResponse> modules) {

        this.courseId = courseId;
        this.learnerId = learnerId;
        this.totalLessons = totalLessons;
        this.completedLessons = completedLessons;
        this.progressPercentage = progressPercentage;
        this.modules = modules;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getLearnerId() {
        return learnerId;
    }

    public int getTotalLessons() {
        return totalLessons;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public List<ModuleProgressResponse> getModules() {
        return modules;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setLearnerId(String learnerId) {
        this.learnerId = learnerId;
    }

    public void setTotalLessons(int totalLessons) {
        this.totalLessons = totalLessons;
    }

    public void setCompletedLessons(int completedLessons) {
        this.completedLessons = completedLessons;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public void setModules(List<ModuleProgressResponse> modules) {
        this.modules = modules;
    }
}