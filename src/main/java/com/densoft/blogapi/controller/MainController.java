package com.densoft.blogapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;


@ApiIgnore
@Controller
public class MainController {
    @GetMapping("/")
    public String index(Model model){
        return  "redirect:/swagger-ui/";
    }
}
