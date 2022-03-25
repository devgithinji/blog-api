package com.densoft.blogapi.payload;

import com.densoft.blogapi.entity.Post;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;

    public PostDto mapToDTO(Post post) {
        PostDto postResponse = new PostDto();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        postResponse.setDescription(post.getDescription());
        postResponse.setContent(post.getContent());
        return postResponse;
    }

    public Post mapToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
