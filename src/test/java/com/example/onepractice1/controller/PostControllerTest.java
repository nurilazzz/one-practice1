package com.example.onepractice1.controller;

import com.example.onepractice1.dto.PostDto;
import com.example.onepractice1.models.Post;
import com.example.onepractice1.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;

class PostControllerTest {
    @Mock
    PostService postService;
    @InjectMocks
    PostController postController;

    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        post = new Post(1L, "name1", "desc2", "SENT");
    }

    @Test
    void testAddPost() {
        when(postService.savePost(any())).thenReturn(post);

        ResponseEntity<PostDto> result = postController.addPost(post);
        Assertions.assertEquals(CREATED, result.getStatusCode());
    }

    @Test
    void testGetAllPosts() {
        when(postService.getAllPosts()).thenReturn(Arrays.asList(post));

        ResponseEntity<List<PostDto>> result = postController.getAllPosts();
        List<PostDto> resultExpected = postService.getAllPosts().stream()
                .map(post1 -> postController.convertToDto(post1)).collect(Collectors.toList());

        Assertions.assertEquals(ResponseEntity.ok(resultExpected), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme