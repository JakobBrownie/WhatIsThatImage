package com.imagesearch.imagesearch.dao;

import java.util.List;

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
	
	@Override
	public List<CommentDTO> getAllCommentsByPostId(int id) throws Exception
	{
		return commentRepository.findByPostId(id);
	}
}
