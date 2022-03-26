package com.densoft.blogapi.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class CommentDto {
    private Long id;
    @NotEmpty(message = "Name should not be null or empty")
    private String name;
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;
    @NotEmpty(message = "Comment should not be empty or null")
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;
}
