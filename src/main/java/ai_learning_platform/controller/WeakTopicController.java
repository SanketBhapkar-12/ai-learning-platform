package ai_learning_platform.controller;

import ai_learning_platform.dto.TopicPerformance;
import ai_learning_platform.service.WeakTopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weak-topics")
public class WeakTopicController {

    private final WeakTopicService weakTopicService;

    public WeakTopicController(WeakTopicService weakTopicService) {
        this.weakTopicService = weakTopicService;
    }

    @GetMapping("/{learnerId}")
    public List<TopicPerformance> analyzeLearner(
            @PathVariable String learnerId) {

        return weakTopicService.analyzeLearner(learnerId);
    }
    @GetMapping("/{learnerId}/weak")
    public List<TopicPerformance> getWeakTopics(
        @PathVariable String learnerId) {

        return weakTopicService.getWeakTopics(learnerId);
    }
}