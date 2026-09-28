package ai_learning_platform.dto;

public class ModuleProgressResponse {

    private String moduleId;
    private String learnerId;
    private int totalLessons;
    private int completedLessons;
    private double progressPercentage;

    public ModuleProgressResponse() {
    }

    public ModuleProgressResponse(
            String moduleId,
            String learnerId,
            int totalLessons,
            int completedLessons,
            double progressPercentage) {

        this.moduleId = moduleId;
        this.learnerId = learnerId;
        this.totalLessons = totalLessons;
        this.completedLessons = completedLessons;
        this.progressPercentage = progressPercentage;
    }

    public String getModuleId() {
        return moduleId;
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

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
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
}
