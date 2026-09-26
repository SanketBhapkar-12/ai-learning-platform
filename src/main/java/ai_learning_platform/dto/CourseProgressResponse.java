package ai_learning_platform.dto;

public class CourseProgressResponse {

    private String courseId;
    private String learnerId;
    private int totalLessons;
    private int completedLessons;
    private double progressPercentage;

    public CourseProgressResponse() {
    }

    public CourseProgressResponse(
            String courseId,
            String learnerId,
            int totalLessons,
            int completedLessons,
            double progressPercentage) {

        this.courseId = courseId;
        this.learnerId = learnerId;
        this.totalLessons = totalLessons;
        this.completedLessons = completedLessons;
        this.progressPercentage = progressPercentage;
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
}