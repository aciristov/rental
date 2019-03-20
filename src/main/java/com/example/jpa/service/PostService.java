package com.example.jpa.service;

import com.example.jpa.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> findAll();

}
