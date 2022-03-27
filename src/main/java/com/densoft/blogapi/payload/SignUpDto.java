package com.densoft.blogapi.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SignUpDto {
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "username is required")
    @Size(min = 3,message = "password should be at least three characters")
    private String username;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @NotEmpty(message = "password is required")
    @Size(min = 6,message = "password should be at least six characters")
    private String password;
}
