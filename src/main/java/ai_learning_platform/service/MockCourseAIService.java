package ai_learning_platform.service;

import ai_learning_platform.dto.GeneratedCourse;
import ai_learning_platform.dto.GeneratedLesson;
import ai_learning_platform.dto.GeneratedModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockCourseAIService {

    public GeneratedCourse generateCourse(
            String topic,
            String difficulty,
            int durationInDays) {

        GeneratedLesson lesson1 = new GeneratedLesson();
        lesson1.setTitle("Introduction to " + topic);
        lesson1.setContent(
                "Learn the fundamental concepts and terminology of " + topic + "."
        );
        lesson1.setTopic(topic + " Fundamentals");
        lesson1.setOrder(1);
        lesson1.setEstimatedMinutes(30);

        GeneratedLesson lesson2 = new GeneratedLesson();
        lesson2.setTitle(topic + " Core Concepts");
        lesson2.setContent(
                "Understand the important concepts and practical foundations of " + topic + "."
        );
        lesson2.setTopic(topic + " Fundamentals");
        lesson2.setOrder(2);
        lesson2.setEstimatedMinutes(45);

        GeneratedModule module1 = new GeneratedModule();
        module1.setTitle(topic + " Fundamentals");
        module1.setDescription(
                "Learn the fundamental concepts required to understand " + topic + "."
        );
        module1.setOrder(1);
        module1.setLessons(List.of(lesson1, lesson2));

        GeneratedLesson lesson3 = new GeneratedLesson();
        lesson3.setTitle("Building with " + topic);
        lesson3.setContent(
                "Apply the concepts of " + topic + " by building a practical example."
        );
        lesson3.setTopic(topic + " Practical Development");
        lesson3.setOrder(1);
        lesson3.setEstimatedMinutes(60);

        GeneratedModule module2 = new GeneratedModule();
        module2.setTitle(topic + " Practical Development");
        module2.setDescription(
                "Apply " + topic + " concepts through practical development."
        );
        module2.setOrder(2);
        module2.setLessons(List.of(lesson3));

        GeneratedCourse course = new GeneratedCourse();

        course.setTitle(topic + " - Complete Learning Path");
        course.setDescription(
                "A structured learning path for mastering "
                        + topic
                        + " at "
                        + difficulty
                        + " level."
        );
        course.setTopic(topic);
        course.setDifficulty(difficulty);
        course.setDurationInDays(durationInDays);
        course.setModules(List.of(module1, module2));

        return course;
    }
}