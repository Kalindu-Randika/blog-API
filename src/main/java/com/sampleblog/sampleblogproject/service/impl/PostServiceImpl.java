package com.sampleblog.sampleblogproject.service.impl;

import com.sampleblog.sampleblogproject.entity.Post;
import com.sampleblog.sampleblogproject.exception.ResourceNotFoundExtension;
import com.sampleblog.sampleblogproject.payload.PostDto;
import com.sampleblog.sampleblogproject.repository.PostRepository;
import com.sampleblog.sampleblogproject.service.PostService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private Post post;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // Convert DTO to Entity

//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());

        Post post = mapToEntity(postDto);

        Post newPost = postRepository.save(post);

        //convert entity to DTO
        PostDto postResponse = mapToDto(newPost);
        return postResponse;




    }

    public Optional<Post> getPostById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) throws ChangeSetPersister.NotFoundException {
        // Get data by id from the database
        Post post = postRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        // Update the fields from the DTO
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);

        return mapToDto(updatedPost);
    }



    @Override
    public List<PostDto> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    // create private method with common code

    private PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        return postDto;
    }

    // converted DTO to entity

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }


}
