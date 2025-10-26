package com.arturocastro.apisb.dto;

public class TextGenerationRequest {

    private String prompt;
    private String model;
    private Double temperature;
    private Long maxTokens;

    public TextGenerationRequest() {
    }
    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }

    public Long getMaxTokens() { return maxTokens; }
    public void setMaxTokens(Long maxTokens) { this.maxTokens = maxTokens; }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    @Override
    public String toString() {
        return "TextGenerationRequest{" +
                "prompt='" + prompt + '\'' +
                ", model='" + model + '\'' +
                ", temperature=" + temperature +
                ", maxTokens=" + maxTokens +
                '}';
    }
}
