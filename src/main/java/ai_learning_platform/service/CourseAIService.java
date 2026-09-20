package ai_learning_platform.service;

import ai_learning_platform.dto.CourseGenerationRequest;
import ai_learning_platform.dto.GeneratedCourse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class CourseAIService {

    private final GeminiService geminiService;
    private final ObjectMapper objectMapper;

    public CourseAIService(
            GeminiService geminiService,
            ObjectMapper objectMapper) {

        this.geminiService = geminiService;
        this.objectMapper = objectMapper;
    }

    public GeneratedCourse generateCourse(
            CourseGenerationRequest request) {

        String prompt = buildCoursePrompt(request);

        String jsonResponse = geminiService.generateJson(prompt);

        try {
            return objectMapper.readValue(
                    jsonResponse,
                    GeneratedCourse.class
            );
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(
                    "Failed to parse AI generated course JSON",
                    exception
            );
        }
    }

    private String buildCoursePrompt(
            CourseGenerationRequest request) {

        return """
                You are an expert AI course designer.

                Create a structured learning course based on the following requirements:

                Topic: %s
                Difficulty: %s
                Duration: %d days

                The course should contain:
                - A clear course title
                - A concise course description
                - Multiple learning modules
                - Multiple lessons inside each module
                - Practical and logically ordered learning content
                - Estimated learning time for each lesson

                The course should progress from foundational concepts
                toward more advanced concepts appropriate for the requested difficulty.

                Return ONLY valid JSON.

                The JSON must follow this exact structure:

                {
                  "title": "Course title",
                  "description": "Course description",
                  "topic": "Requested topic",
                  "difficulty": "Requested difficulty",
                  "durationInDays": 7,
                  "modules": [
                    {
                      "title": "Module title",
                      "description": "Module description",
                      "order": 1,
                      "lessons": [
                        {
                          "title": "Lesson title",
                          "content": "Lesson content",
                          "order": 1,
                          "estimatedMinutes": 30
                        }
                      ]
                    }
                  ]
                }

                Do not use Markdown.
                Do not use code fences.
                Do not add any text before or after the JSON.
                """
                .formatted(
                        request.getTopic(),
                        request.getDifficulty(),
                        request.getDurationInDays()
                );
    }
}