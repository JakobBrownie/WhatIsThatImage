package com.imagesearch.imagesearch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imagesearch.imagesearch.dto.PostDTO;

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
	
}
