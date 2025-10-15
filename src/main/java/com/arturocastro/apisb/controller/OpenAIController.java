package com.arturocastro.apisb.controller;

import com.arturocastro.apisb.sevice.OpenAIService;
import com.openai.models.responses.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/openai")
public class OpenAIController {

    private final OpenAIService openAIService;

    private OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping("/question")
    public Response getQuestion(){
        return openAIService.getQuestion();
    }

}
