package com.densoft.blogapi.service;

import com.densoft.blogapi.payload.PostDto;
import com.densoft.blogapi.payload.PostResponse;


public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
