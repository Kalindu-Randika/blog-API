package com.sampleblog.sampleblogproject.controller;

import com.sampleblog.sampleblogproject.payload.CommentDto;
import com.sampleblog.sampleblogproject.service.CommentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {


    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable Long postId){
        return commentService.getCommentsByPostId(postId);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable long postId, @RequestBody CommentDto commentDto) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto),HttpStatus.CREATED);
    }
}
