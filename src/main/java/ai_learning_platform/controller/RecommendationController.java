package ai_learning_platform.controller;

import ai_learning_platform.dto.AdaptiveRecommendationResponse;
import ai_learning_platform.dto.RecommendedLesson;
import ai_learning_platform.service.AdaptiveRecommendationService;
import ai_learning_platform.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;
    private final AdaptiveRecommendationService adaptiveRecommendationService;

    public RecommendationController(
            RecommendationService recommendationService,
            AdaptiveRecommendationService adaptiveRecommendationService) {

        this.recommendationService = recommendationService;
        this.adaptiveRecommendationService =
                adaptiveRecommendationService;
    }

    @GetMapping("/{learnerId}")
    public List<RecommendedLesson> getRecommendations(
            @PathVariable String learnerId) {

        return recommendationService.getRecommendations(learnerId);
    }

    @GetMapping("/adaptive/{learnerId}")
    public List<AdaptiveRecommendationResponse> getAdaptiveRecommendations(
            @PathVariable String learnerId) {

        return adaptiveRecommendationService
                .generateRecommendations(learnerId);
    }
}