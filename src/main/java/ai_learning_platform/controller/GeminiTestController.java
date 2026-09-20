package ai_learning_platform.controller;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeminiTestController {

    private final Client geminiClient;

    public GeminiTestController(Client geminiClient) {
        this.geminiClient = geminiClient;
    }

    @GetMapping("/api/gemini/test")
    public String testGemini() {

        GenerateContentResponse response =
                geminiClient.models.generateContent(
                        "gemini-3.8-flash",
                        "Say hello to my AI Learning Platform in one sentence.",
                        null
                );

        return response.text();
    }
}