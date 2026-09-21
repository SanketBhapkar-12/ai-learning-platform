package ai_learning_platform.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "quizzes")
public class Quiz {

    @Id
    private String id;

    private String lessonId;
    private String title;
    private List<QuizQuestion> questions;

    public Quiz() {
    }

    public Quiz(
            String lessonId,
            String title,
            List<QuizQuestion> questions) {

        this.lessonId = lessonId;
        this.title = title;
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getTitle() {
        return title;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<QuizQuestion> questions) {
        this.questions = questions;
    }
}