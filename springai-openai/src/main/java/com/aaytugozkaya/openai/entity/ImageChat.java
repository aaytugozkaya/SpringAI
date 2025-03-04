package com.aaytugozkaya.openai.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageChat {
    private String prompt;
    private List<String> imagePath;
}
