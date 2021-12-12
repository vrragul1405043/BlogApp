package com.springboot.blog.springbootblogrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.springbootblogrestapi.payload.PostDTO;
import com.springboot.blog.springbootblogrestapi.service.PostService;

@RestController
@RequestMapping("api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
		return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<PostDTO> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public PostDTO getPostById(@PathVariable("id")long id) {
		return postService.getPost(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable("id")long id){
		return new ResponseEntity<>(postService.updatePost(postDTO,id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PostDTO> deletePost(@PathVariable("id")long id){
		postService.deletePostById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
	

}
