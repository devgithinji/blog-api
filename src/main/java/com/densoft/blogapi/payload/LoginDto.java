package com.densoft.blogapi.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class LoginDto {

    @NotEmpty(message = "username / email is required")
    private String usernameOrEmail;
    @NotEmpty(message = "password is required")
    private String password;
}
