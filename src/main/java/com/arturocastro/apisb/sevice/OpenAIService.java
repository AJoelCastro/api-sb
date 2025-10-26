package com.arturocastro.apisb.sevice;

import com.arturocastro.apisb.dto.TextGenerationRequest;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
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

    public Response getQuestion(TextGenerationRequest req){
        if (req == null || req.getPrompt() == null || req.getPrompt().isEmpty()) {
            throw new IllegalArgumentException("Prompt vacío o nulo");
        }

        ResponseCreateParams params = ResponseCreateParams
                .builder()
                .model(ChatModel.GPT_4_1_MINI)
                .temperature(req.getTemperature())
                .maxOutputTokens(req.getMaxTokens())
                .input(req.getPrompt())
                .build();
        return client.responses().create(params);
    }

    public Response getStructuredOutput(TextGenerationRequest req){
        if (req == null || req.getPrompt() == null || req.getPrompt().isEmpty()) {
            throw new IllegalArgumentException("Prompt vacío o nulo");
        }

        String prompt = """
            Eres un asistente experto en cocina.
            Devuelve una respuesta en formato JSON válido con los pasos y duración estimada.

            Pregunta: %s

            Formato de respuesta:
            {
              "question": "<repite la pregunta>",
              "answer": [
                {
                  "content": "Paso 1: ...",
                  "duration": 0.0
                }
              ]
            }
            """.formatted(req.getPrompt());

        ResponseCreateParams params = ResponseCreateParams
                .builder()
                .model(ChatModel.GPT_4_1_MINI)
                .input(prompt)
                .build();
        return client.responses().create(params);
    }

}
