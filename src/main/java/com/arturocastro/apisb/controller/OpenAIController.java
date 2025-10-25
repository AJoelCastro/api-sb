package com.arturocastro.apisb.controller;

import com.arturocastro.apisb.dto.TextGenerationRequest;
import com.arturocastro.apisb.sevice.OpenAIService;
import com.openai.models.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
public class OpenAIController {

    private final OpenAIService openAIService;

    private OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/text-generation")
    public ResponseEntity<Response> getQuestion(@RequestBody TextGenerationRequest req){
        return ResponseEntity.ok(openAIService.getQuestion(req));
    }

}
