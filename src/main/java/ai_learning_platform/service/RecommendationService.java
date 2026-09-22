package ai_learning_platform.service;

import ai_learning_platform.dto.RecommendedLesson;
import ai_learning_platform.dto.TopicPerformance;
import ai_learning_platform.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    private final WeakTopicService weakTopicService;
    private final LessonService lessonService;

    public RecommendationService(
            WeakTopicService weakTopicService,
            LessonService lessonService) {

        this.weakTopicService = weakTopicService;
        this.lessonService = lessonService;
    }

    public List<RecommendedLesson> getRecommendations(
            String learnerId) {

        List<TopicPerformance> weakTopics =
                weakTopicService.getWeakTopics(learnerId);

        List<RecommendedLesson> recommendations =
                new ArrayList<>();

        for (TopicPerformance weakTopic : weakTopics) {

            List<Lesson> lessons =
                    lessonService.getLessonsByTopic(
                            weakTopic.getTopic()
                    );

            for (Lesson lesson : lessons) {

                String reason =
                        "Recommended because " +
                        weakTopic.getTopic() +
                        " is a weak topic with " +
                        weakTopic.getAccuracy() +
                        "% accuracy.";

                recommendations.add(
                        new RecommendedLesson(
                                lesson.getId(),
                                lesson.getTitle(),
                                lesson.getTopic(),
                                lesson.getEstimatedMinutes(),
                                weakTopic.getAccuracy(),
                                reason
                        )
                );
            }
        }

        return recommendations;
    }
}