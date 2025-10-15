package com.arturocastro.apisb.sevice;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService {

    private final OpenAIClient client;

    public OpenAIService(@Value("${openai.api.key}") String apiKey) {
        client = new OpenAIOkHttpClient.Builder()
                .apiKey(apiKey)
                .build();
    }

    public Response getQuestion(){
        ResponseCreateParams responseCreateParams = ResponseCreateParams.builder()
                .input("What is the capital of Spain?")
                .build();
        Response response = client.responses().create(responseCreateParams);
        return response;
    }

}
