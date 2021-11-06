package com.example.onepractice1.controller;

import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
import com.example.onepractice1.models.dto.PostDto;
import com.example.onepractice1.service.PostService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController {
    private final ModelMapper modelMapper;

    private final PostService postService;

    @Autowired
    public PostController(ModelMapper modelMapper, PostService postService) {
        this.modelMapper = modelMapper;
        this.postService = postService;
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<PostDto> getPost(@PathVariable(name = "post_id") Long postId) {
        Post post = postService.getPostById(postId);

        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(convertToDto(post), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDto> addPost(@RequestBody Post post) {
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Post savedPost = postService.savePost(post);

        return new ResponseEntity<>(convertToDto(savedPost), HttpStatus.CREATED);
    }

    @PutMapping("/update/{post_id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable(name = "post_id") Long postId,
                                              @RequestBody Post newPost) {
        if (newPost == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Post post = postService.getPostById(postId);

        post.setName(newPost.getName());
        post.setPostStatus(newPost.getPostStatus());

        Post savedPost = postService.savePost(post);

        return new ResponseEntity<>(convertToDto(savedPost), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{post_id}")
    public ResponseEntity<Post> deletePostById(@PathVariable(name = "post_id") Long postId) {
        Post post = postService.getPostById(postId);

        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        postService.deletePostById(postId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
