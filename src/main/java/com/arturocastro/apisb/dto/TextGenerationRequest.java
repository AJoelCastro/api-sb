package com.arturocastro.apisb.dto;

public class TextGenerationRequest {

    private String prompt;
    private int maxTokens;
    private String role;
    private String instruction;

    // ✅ Getters y setters (necesarios para @RequestBody)
    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }

    public int getMaxTokens() { return maxTokens; }
    public void setMaxTokens(int maxTokens) { this.maxTokens = maxTokens; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getInstruction() { return instruction; }
    public void setInstruction(String instruction) { this.instruction = instruction; }
}
