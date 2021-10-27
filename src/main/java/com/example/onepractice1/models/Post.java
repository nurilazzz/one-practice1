package com.example.onepractice1.models;

import com.example.onepractice1.models.enumuration.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long id;
    private String description;
    private String postStatus;
}
