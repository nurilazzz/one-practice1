package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.PostRepository;
import com.example.onepractice1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find post with %s id", id)));
    }

    @Override
    public Post savePost(Post post) {
        return Optional.of(postRepository.save(post)).orElseThrow();
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
