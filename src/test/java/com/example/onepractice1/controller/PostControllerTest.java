package com.example.onepractice1.controller;

import com.example.onepractice1.models.Post;
import com.example.onepractice1.dto.PostDto;
import com.example.onepractice1.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PostControllerTest {
    @Mock
    ModelMapper modelMapper;
    @Mock
    PostService postService;
    @InjectMocks
    PostController postController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPost() {
        when(postService.getPostById(anyLong())).thenReturn(new Post(Long.valueOf(1), "name", "description", "postStatus"));

        ResponseEntity<PostDto> result = postController.getPost(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddPost() {
        when(postService.savePost(any())).thenReturn(new Post(Long.valueOf(1), "name", "description", "postStatus"));

        ResponseEntity<PostDto> result = postController.addPost(new Post(Long.valueOf(1), "name", "description", "postStatus"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testUpdatePost() {
        when(postService.getPostById(anyLong())).thenReturn(new Post(Long.valueOf(1), "name", "description", "postStatus"));
        when(postService.savePost(any())).thenReturn(new Post(Long.valueOf(1), "name", "description", "postStatus"));

        ResponseEntity<PostDto> result = postController.updatePost(Long.valueOf(1), new Post(Long.valueOf(1), "name", "description", "postStatus"));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeletePostById() {
        when(postService.getPostById(anyLong())).thenReturn(new Post(Long.valueOf(1), "name", "description", "postStatus"));

        ResponseEntity<Post> result = postController.deletePostById(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetAllPosts() {
        when(postService.getAllPosts()).thenReturn(Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus")));

        ResponseEntity<List<PostDto>> result = postController.getAllPosts();
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme