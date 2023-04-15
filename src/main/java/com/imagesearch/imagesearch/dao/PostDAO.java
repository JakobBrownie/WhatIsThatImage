package com.imagesearch.imagesearch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

import com.imagesearch.imagesearch.dto.PostDTO;
import com.imagesearch.imagesearch.dto.UserDTO;

@Component
public class PostDAO implements IPostDAO {
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public PostDTO save(PostDTO user)
	{
		postRepository.save(user);
		return user;
	}
	
	@Override
	public Iterable<PostDTO> fetchAll() throws Exception
	{
		return postRepository.findAll();
	}
	
	
	@Override
	public List<PostDTO> getPostById(int id) throws Exception
	{
		return postRepository.findByPostId(id);
	}
	
	@Override
	public List<PostDTO> getPostByUserId(int id) throws Exception
	{
		return postRepository.findByUserId(id);
	}
}
