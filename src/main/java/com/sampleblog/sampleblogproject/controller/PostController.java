package com.sampleblog.sampleblogproject.controller;

import com.sampleblog.sampleblogproject.entity.Post;
import com.sampleblog.sampleblogproject.payload.PostDto;
import com.sampleblog.sampleblogproject.service.PostService;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post Rest API endpoint

    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable long id) throws ChangeSetPersister.NotFoundException {

        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

}
