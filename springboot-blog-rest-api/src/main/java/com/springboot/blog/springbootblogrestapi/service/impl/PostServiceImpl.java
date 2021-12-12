package com.springboot.blog.springbootblogrestapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.springbootblogrestapi.entity.Post;
import com.springboot.blog.springbootblogrestapi.exception.ResourceNotFoundException;
import com.springboot.blog.springbootblogrestapi.payload.PostDTO;
import com.springboot.blog.springbootblogrestapi.repository.PostRepository;
import com.springboot.blog.springbootblogrestapi.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public PostDTO createPost(PostDTO postDto) {
		
		Post post = mapToEntity(postDto);
		Post newPost =  postRepository.save(post);
		
		PostDTO responsePostDto = mapToDto(newPost);
		return responsePostDto;
	}

	@Override
	public List<PostDTO> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
	}
	
	@Override
	public PostDTO getPost(long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		return mapToDto(post);
	}
	
	@Override
	public PostDTO updatePost(PostDTO postDto, long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		post.setTitle(postDto.getTitle());
		Post updatedPost =  postRepository.save(post);
		return mapToDto(updatedPost);
	}
	
	@Override
	public void deletePostById(long id) {
		postRepository.deleteById(id);
	}
	
	
	
	private PostDTO mapToDto(Post post) {
		PostDTO postDto = new PostDTO();
		postDto.setContent(post.getContent());
		postDto.setDescription(post.getDescription());
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		return postDto;
	}
	
	private Post mapToEntity(PostDTO postDto) {
		Post post = new Post();
		post.setId(postDto.getId());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		post.setTitle(postDto.getTitle());
		return post;
		
	}

	

	

	
	
	

}
