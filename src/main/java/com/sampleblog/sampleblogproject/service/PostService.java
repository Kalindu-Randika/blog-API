package com.sampleblog.sampleblogproject.service;

import com.sampleblog.sampleblogproject.entity.Post;
import com.sampleblog.sampleblogproject.payload.PostDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface PostService {


    List<PostDto> getAllPosts();

    PostDto createPost(PostDto postDto);

    Optional<Post> getPostById(long id);

    PostDto updatePost(PostDto postDto, long id) throws ChangeSetPersister.NotFoundException;
}
