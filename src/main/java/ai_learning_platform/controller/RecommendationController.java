package ai_learning_platform.controller;

import ai_learning_platform.dto.RecommendedLesson;
import ai_learning_platform.service.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService) {

        this.recommendationService = recommendationService;
    }

    @GetMapping("/{learnerId}")
    public List<RecommendedLesson> getRecommendations(
            @PathVariable String learnerId) {

        return recommendationService.getRecommendations(learnerId);
    }
}