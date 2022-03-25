package com.densoft.blogapi.service.impl;

import com.densoft.blogapi.entity.Post;
import com.densoft.blogapi.exception.ResourceNotFoundException;
import com.densoft.blogapi.payload.PostDto;
import com.densoft.blogapi.repository.PostRepository;
import com.densoft.blogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private PostDto dto;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostDto postDto) {
        this.postRepository = postRepository;
        this.dto = postDto;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = dto.mapToPost(postDto);
        Post newPost = postRepository.save(post);
        return dto.mapToDTO(newPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> dto.mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return dto.mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //get post by id from db
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return dto.mapToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }
}
