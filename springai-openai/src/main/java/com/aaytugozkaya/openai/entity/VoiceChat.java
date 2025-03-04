package com.aaytugozkaya.openai.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoiceChat {
    private String prompt;
    private List<String> voicePath;
}
