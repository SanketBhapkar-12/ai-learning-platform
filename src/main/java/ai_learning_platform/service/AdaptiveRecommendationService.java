package ai_learning_platform.service;

import ai_learning_platform.dto.AdaptiveRecommendationResponse;
import ai_learning_platform.dto.TopicPerformance;
import ai_learning_platform.model.Lesson;
import ai_learning_platform.model.Module;
import ai_learning_platform.model.Progress;
import ai_learning_platform.model.ProgressStatus;
import ai_learning_platform.repository.ModuleRepository;
import ai_learning_platform.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdaptiveRecommendationService {

    private final WeakTopicService weakTopicService;
    private final LessonService lessonService;
    private final ProgressRepository progressRepository;
    private final ModuleRepository moduleRepository;

    public AdaptiveRecommendationService(
            WeakTopicService weakTopicService,
            LessonService lessonService,
            ProgressRepository progressRepository,
            ModuleRepository moduleRepository) {

        this.weakTopicService = weakTopicService;
        this.lessonService = lessonService;
        this.progressRepository = progressRepository;
        this.moduleRepository = moduleRepository;
    }

    public List<TopicPerformance> getWeakTopics(
            String learnerId) {

        return weakTopicService.getWeakTopics(learnerId);
    }

    public List<Lesson> getLessonsForWeakTopic(
            String topic) {

        return lessonService.getLessonsByTopic(topic);
    }

    public List<Lesson> getIncompleteLessons(
            String learnerId,
            List<Lesson> lessons) {

        List<Lesson> incompleteLessons =
                new ArrayList<>();

        for (Lesson lesson : lessons) {

            Progress progress =
                    progressRepository
                            .findByLearnerIdAndLessonId(
                                    learnerId,
                                    lesson.getId()
                            )
                            .orElse(null);

            if (progress == null
                    || progress.getStatus()
                    != ProgressStatus.COMPLETED) {

                incompleteLessons.add(lesson);
            }
        }

        return incompleteLessons;
    }

    private Module getModuleForLesson(Lesson lesson) {

        return moduleRepository.findById(lesson.getModuleId())
                .orElse(null);
    }

    private double calculateRecommendationScore(
            double topicAccuracy,
            int moduleOrder,
            int lessonOrder) {

        double weaknessScore =
                100.0 - topicAccuracy;

        double moduleOrderBonus = 0;

        if (moduleOrder == 1) {
            moduleOrderBonus = 10;
        } else if (moduleOrder == 2) {
            moduleOrderBonus = 5;
        }

        double lessonOrderBonus = 0;

        if (lessonOrder == 1) {
            lessonOrderBonus = 5;
        } else if (lessonOrder == 2) {
            lessonOrderBonus = 2;
        }

        return weaknessScore
                + moduleOrderBonus
                + lessonOrderBonus;
    }

    private String calculatePriority(
            double recommendationScore) {

        if (recommendationScore >= 100) {
            return "HIGH";
        }

        if (recommendationScore >= 70) {
            return "MEDIUM";
        }

        return "LOW";
    }

    public List<AdaptiveRecommendationResponse> generateRecommendations(
            String learnerId) {

        List<TopicPerformance> weakTopics =
                weakTopicService.getWeakTopics(learnerId);

        List<AdaptiveRecommendationResponse> recommendations =
                new ArrayList<>();

        for (TopicPerformance performance : weakTopics) {

            String topic = performance.getTopic();

            double topicAccuracy =
                    performance.getAccuracy();

            List<Lesson> lessons =
                    lessonService.getLessonsByTopic(topic);

            List<Lesson> incompleteLessons =
                    getIncompleteLessons(
                            learnerId,
                            lessons
                    );

            for (Lesson lesson : incompleteLessons) {

                Module module =
                        getModuleForLesson(lesson);

                if (module == null) {
                    continue;
                }

                double recommendationScore =
                        calculateRecommendationScore(
                                topicAccuracy,
                                module.getOrder(),
                                lesson.getOrder()
                        );

                String priority =
                        calculatePriority(
                                recommendationScore
                        );

                String reason =
                        "Recommended because "
                                + topic
                                + " is a weak topic with "
                                + topicAccuracy
                                + "% accuracy.";

                recommendations.add(
                        new AdaptiveRecommendationResponse(
                                lesson.getId(),
                                lesson.getTitle(),
                                lesson.getTopic(),
                                lesson.getEstimatedMinutes(),
                                topicAccuracy,
                                priority,
                                recommendationScore,
                                reason
                        )
                );
            }
        }

        recommendations.sort(
                (first, second) ->
                        Double.compare(
                                second.getRecommendationScore(),
                                first.getRecommendationScore()
                        )
        );

        return recommendations;
    }
}
