package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class PostServiceImplTest {
    @Mock
    PostRepository postRepository;
    @InjectMocks
    PostServiceImpl sut;

    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        post = new Post(1L, "name1", "desc2", "SENT");
    }

    @Test
    void testGetAllPosts() {
        when(postRepository.findAll()).thenReturn(List.of(post));

        List<Post> result = sut.getAllPosts();
        Assertions.assertEquals(List.of(post), result);
    }

    @Test
    void testGetPostById() {
    }

    @Test
    void testSavePost() {
    }

    @Test
    void testDeletePostById() {

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme