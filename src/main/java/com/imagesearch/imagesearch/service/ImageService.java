package com.imagesearch.imagesearch.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import com.imagesearch.imagesearch.dao.ICommentDAO;
import com.imagesearch.imagesearch.dao.IPostDAO;
import com.imagesearch.imagesearch.dao.IUserDAO;
import com.imagesearch.imagesearch.dto.CommentDTO;
import com.imagesearch.imagesearch.dto.PostDTO;
import com.imagesearch.imagesearch.dto.UserDTO;

@Component
public class ImageService implements IImageService {
	
	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	IPostDAO postDAO;
	
	@Autowired
	ICommentDAO commentDAO;
	
	//calls save from userDAO
	public boolean save(UserDTO userDTO) throws Exception
	{
		userDAO.save(userDTO);
		return false;
	}
	//calls save from postDAO
	@Override
	public boolean savePost(PostDTO postDTO) throws Exception
	{
		postDAO.save(postDTO);
		return false;
	}
	
	@Override
	public boolean saveComment(CommentDTO commentDTO) throws Exception
	{
		commentDAO.save(commentDTO);
		return false;
	}
	
	//gets all users
	@Override
	public Iterable<UserDTO> fetchAllUsers() throws Exception
	{
		return userDAO.fetchAll();
	}
	
	//gets all posts
	@Override
	public Iterable<PostDTO> fetchAllPosts() throws Exception
	{
		return postDAO.fetchAll();
	}
	
	//gets all comments
	@Override
	public Iterable<CommentDTO> fetchAllComments() throws Exception
	{
		return commentDAO.fetchAll();
	}
	
	//get post by post id
	@Override
	public List<PostDTO> getPostById(int id) throws Exception
	{
		return postDAO.getPostById(id);
	}
	
	//get post by user id
	@Override
	public List<PostDTO> getPostByUserId(int userId) throws Exception
	{
		return postDAO.getPostByUserId(userId);
	}
	
	//get all comments related to a post
	@Override
	public List<CommentDTO> getAllCommentsByPostId(int id) throws Exception
	{
		return commentDAO.getAllCommentsByPostId(id);
	}
	
	//get user by user id
	@Override
	public List<UserDTO> getUserById(int id) throws Exception
	{
		return userDAO.getUserById(id);
	}


}
