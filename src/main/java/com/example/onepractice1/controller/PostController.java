package com.example.onepractice1.controller;

import com.example.onepractice1.models.Post;
import com.example.onepractice1.dto.PostDto;
import com.example.onepractice1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> addPost(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);

        return new ResponseEntity<>(convertToDto(savedPost), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();

        if (posts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<PostDto> postDTOList = posts.stream()
                .map(this::convertToDto).collect(Collectors.toList());

        return new ResponseEntity<>(postDTOList, HttpStatus.OK);
    }

    private PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();

        postDto.setName(post.getName());
        postDto.setPostStatus(post.getPostStatus());

        return postDto;
    }

}
