package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class PostServiceImplTest {
    @Mock
    static PostRepository postRepository;
    @InjectMocks
    static PostServiceImpl postServiceImpl;

    @BeforeAll
    static void setUp() {
        Post post = new Post(1L,"Nurila","Zharkynbek",new Client(1L,"Nurila","Zharkynbek","n@gmail.com",new Address(1L,"KZ","ALA","Saina",12,21)));
        postServiceImpl.savePost(post);
    }

    @Test
    void testGetAllPosts() {
        Assertions.assertFalse(postServiceImpl.getAllPosts().isEmpty());
    }

    @Test
    void testGetPostById() {
        Post result = postServiceImpl.getPostById(1L);
        Assertions.assertEquals("Nurila",result.getDescription());
    }

    @Test
    void testSavePost() {
        Post result = postServiceImpl.getPostById(1L);
        result.setDescription("Nurila");
        Assertions.assertEquals("Nurila",result.getDescription());
    }

    @Test
    void testDeletePostById() {
        postServiceImpl.deletePostById(Long.valueOf(1));
    }
}

