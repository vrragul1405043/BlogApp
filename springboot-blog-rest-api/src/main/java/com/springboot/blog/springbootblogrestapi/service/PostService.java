package com.springboot.blog.springbootblogrestapi.service;

import java.util.List;

import com.springboot.blog.springbootblogrestapi.payload.PostDTO;

public interface PostService {
	
	PostDTO createPost(PostDTO postDto);
	List<PostDTO> getAllPosts();
	PostDTO getPost(long id);
	PostDTO updatePost(PostDTO postDto, long id);
	void deletePostById(long id);
}
