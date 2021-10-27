package com.example.onepractice1.service;

import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findPostById(Long id){
        return postRepository.findPostById(id);
    }

    public void savePost(Post post){
        postRepository.savePost(post);
    }

    public boolean deletePostById(Long id){
        return postRepository.deletePostById(id);
    }
}
