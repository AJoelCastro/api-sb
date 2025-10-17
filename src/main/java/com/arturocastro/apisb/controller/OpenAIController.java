package com.arturocastro.apisb.controller;

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

    @PostMapping("/question")
    public ResponseEntity<Response> getQuestion(@RequestBody String question){
        return ResponseEntity.ok(openAIService.getQuestion(question));
    }

}
