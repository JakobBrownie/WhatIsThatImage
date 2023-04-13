package com.imagesearch.imagesearch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imagesearch.imagesearch.dto.CommentDTO;
import com.imagesearch.imagesearch.dto.PostDTO;

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
	
	@Override
	public Iterable<CommentDTO> fetchAll() throws Exception
	{
		return commentRepository.findAll();
	}
}
