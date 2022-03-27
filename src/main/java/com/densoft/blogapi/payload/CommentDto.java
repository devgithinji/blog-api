package com.densoft.blogapi.payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Api(value = "Comment model information")
@Data
public class CommentDto {
    @ApiModelProperty(value = "Comment Id")
    private Long id;
    @ApiModelProperty(value = "Comment name")
    @NotEmpty(message = "Name should not be null or empty")
    private String name;
    @ApiModelProperty(value = "Comment Email")
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;
    @ApiModelProperty(value = "Comment body")
    @NotEmpty(message = "Comment should not be empty or null")
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;
}
