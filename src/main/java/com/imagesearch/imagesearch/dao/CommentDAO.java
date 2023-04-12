package com.imagesearch.imagesearch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imagesearch.imagesearch.dto.CommentDTO;

@Component
public class CommentDAO implements ICommentDAO {

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public CommentDTO save(CommentDTO user)
	{
		commentRepository.save(user);
		return user;
	}
}
