package ai_learning_platform.service;

import ai_learning_platform.dto.TopicPerformance;
import ai_learning_platform.model.QuestionAnswer;
import ai_learning_platform.model.Quiz;
import ai_learning_platform.model.QuizAttempt;
import ai_learning_platform.model.QuizQuestion;
import ai_learning_platform.repository.QuizAttemptRepository;
import ai_learning_platform.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeakTopicService {

    private static final double WEAK_TOPIC_THRESHOLD = 60.0;

    private final QuizAttemptRepository quizAttemptRepository;
    private final QuizRepository quizRepository;

    public WeakTopicService(
            QuizAttemptRepository quizAttemptRepository,
            QuizRepository quizRepository) {

        this.quizAttemptRepository = quizAttemptRepository;
        this.quizRepository = quizRepository;
    }

    public List<TopicPerformance> analyzeLearner(
            String learnerId) {

        List<QuizAttempt> attempts =
                quizAttemptRepository.findByLearnerId(learnerId);

        Map<String, Integer> totalQuestionsByTopic =
                new HashMap<>();

        Map<String, Integer> correctAnswersByTopic =
                new HashMap<>();

        for (QuizAttempt attempt : attempts) {

            Quiz quiz = quizRepository.findById(attempt.getQuizId())
                    .orElse(null);

            if (quiz == null) {
                continue;
            }

            for (QuestionAnswer answer : attempt.getAnswers()) {

                QuizQuestion question = quiz.getQuestions()
                        .stream()
                        .filter(q ->
                                q.getId().equals(answer.getQuestionId()))
                        .findFirst()
                        .orElse(null);

                if (question == null) {
                    continue;
                }

                String topic = question.getTopic();

                // Ignore old questions that do not have a topic.
                if (topic == null || topic.isBlank()) {
                    continue;
                }

                totalQuestionsByTopic.put(
                        topic,
                        totalQuestionsByTopic.getOrDefault(topic, 0) + 1
                );

                if (question.getCorrectAnswer()
                        .equals(answer.getSelectedAnswer())) {

                    correctAnswersByTopic.put(
                            topic,
                            correctAnswersByTopic.getOrDefault(topic, 0) + 1
                    );
                }
            }
        }

        List<TopicPerformance> performances =
                new ArrayList<>();

        for (String topic : totalQuestionsByTopic.keySet()) {

            int total =
                    totalQuestionsByTopic.get(topic);

            int correct =
                    correctAnswersByTopic.getOrDefault(topic, 0);

            double accuracy =
                    total == 0
                            ? 0
                            : ((double) correct / total) * 100;

            performances.add(
                    new TopicPerformance(
                            topic,
                            correct,
                            total,
                            accuracy
                    )
            );
        }

        return performances;
    }

    public List<TopicPerformance> getWeakTopics(
            String learnerId) {

        return analyzeLearner(learnerId)
                .stream()
                .filter(performance ->
                        performance.getAccuracy() < WEAK_TOPIC_THRESHOLD)
                .toList();
    }
}