package com.densoft.blogapi.service;

import com.densoft.blogapi.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(long postId, long commentId);

    CommentDto updateComment(Long postId, long commentId, CommentDto commentDto);

    void deleteComment(Long postId, Long commentId);
}
