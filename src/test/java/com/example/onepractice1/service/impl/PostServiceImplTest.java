package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PostServiceImplTest {
    @Mock
    PostRepository postRepository;
    @InjectMocks
    PostServiceImpl postServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPosts() {
        List<Post> result = postServiceImpl.getAllPosts();
        Assertions.assertEquals(Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus")), result);
    }

    @Test
    void testGetPostById() {
        Post result = postServiceImpl.getPostById(Long.valueOf(1));
        Assertions.assertEquals(new Post(Long.valueOf(1), "name", "description", "postStatus"), result);
    }

    @Test
    void testSavePost() {
        Post result = postServiceImpl.savePost(new Post(Long.valueOf(1), "name", "description", "postStatus"));
        Assertions.assertEquals(new Post(Long.valueOf(1), "name", "description", "postStatus"), result);
    }

    @Test
    void testDeletePostById() {
        postServiceImpl.deletePostById(Long.valueOf(1));
    }
}