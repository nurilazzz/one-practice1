package com.example.onepractice1.models.dto;

import com.example.onepractice1.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String name;

    private String postStatus;

    private Client clientId;
}