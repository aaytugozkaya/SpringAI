package com.aaytugozkaya.openai.service;

import com.aaytugozkaya.openai.common.FileUtils;
import com.aaytugozkaya.openai.entity.ImageChat;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.model.Media;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AiService {
    private final OpenAiChatModel chatModel;
    public  String getAiResponse(String prompt){
        return chatModel.call(prompt);
    }

    public String getAiResponseWithImage(ImageChat prompt) {
        List<Media> mediaList = prompt.getImagePath().stream()
                .map(path -> new Media(MimeTypeUtils.IMAGE_JPEG, new ClassPathResource(FileUtils.UPLOAD_DIR + path)))
                .toList();

        var userMessage = new UserMessage(prompt.getPrompt(), mediaList);
        return chatModel.call(userMessage);
    }

    public String getAiResponseWithVoice(ImageChat prompt) {
        List<Media> mediaList = prompt.getImagePath().stream()
                .map(path -> new Media(MimeTypeUtils.parseMimeType("audio/mp3"), new ClassPathResource(FileUtils.UPLOAD_DIR + path)))
                .toList();

        var userMessage = new UserMessage(prompt.getPrompt(), mediaList);
        return chatModel.call(userMessage);
    }

}
