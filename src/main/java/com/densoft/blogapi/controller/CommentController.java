package com.densoft.blogapi.controller;

import com.densoft.blogapi.payload.CommentDto;
import com.densoft.blogapi.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD endpoints for comment resource")
@RestController
@RequestMapping("/api/v1")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "Create comment endpoint")
    @PostMapping("/posts/{post_id}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(name = "post_id") long post_id, @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(post_id, commentDto), HttpStatus.CREATED);
    }


    @ApiOperation(value = "Get all comments by Post Id endpoint")
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(name = "postId") Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @ApiOperation(value = "Get single comment by Id endpoint")
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(name = "postId") Long postId, @PathVariable(name = "commentId") Long commentId) {
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Update comment by Id endpoint")
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(name = "postId") Long postId, @PathVariable(name = "commentId") long commentId, @Valid @RequestBody CommentDto commentDto) {
        CommentDto response = commentService.updateComment(postId, commentId, commentDto);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Delete comment by Id endpoint")
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable(name = "postId") Long postId, @PathVariable(name = "commentId") long commentId) {
        commentService.deleteComment(postId, commentId);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
