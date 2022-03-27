package com.densoft.blogapi;

import com.densoft.blogapi.entity.Role;
import com.densoft.blogapi.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApiApplication implements CommandLineRunner {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApiApplication.class, args);
    }

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);
    }
}
