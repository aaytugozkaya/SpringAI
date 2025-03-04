package com.aaytugozkaya.openai.controller;

import com.aaytugozkaya.openai.entity.ImageChat;
import com.aaytugozkaya.openai.service.AiService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chats")
public class AiController {
    private final AiService aiService;

    @PostMapping("/generate")
    public String generate(@RequestBody String prompt) {
        return aiService.getAiResponse(prompt);
    }

    @PostMapping("/image")
    public String generateChatWithImage(@RequestBody ImageChat prompt) {
        return aiService.getAiResponseWithImage(prompt);
    }

    @PostMapping("/voice")
    public String generateChatWithVoice(@RequestBody ImageChat prompt) {
        return aiService.getAiResponseWithVoice(prompt);
    }
}
