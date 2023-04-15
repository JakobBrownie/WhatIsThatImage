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
	
	public boolean save(UserDTO userDTO) throws Exception
	{
		userDAO.save(userDTO);
		return false;
	}
	@Override
	public boolean savePost(PostDTO postDTO) throws Exception
	{
		postDAO.save(postDTO);
		return false;
	}
	
	@Override
	public UserDTO fetchUserById(int id)
	{
		UserDTO user = new UserDTO();
		user.setUserId(124);
		user.setUserName("test user name test");
		return(user);
	}
	
	@Override
	public Iterable<UserDTO> fetchAllUsers() throws Exception
	{
		return userDAO.fetchAll();
	}
	
	@Override
	public Iterable<PostDTO> fetchAllPosts() throws Exception
	{
		return postDAO.fetchAll();
	}
	
	@Override
	public Iterable<CommentDTO> fetchAllComments() throws Exception
	{
		return commentDAO.fetchAll();
	}
	
	
	@Override
	public List<PostDTO> getPostById(int id) throws Exception
	{
		return postDAO.getPostById(id);
	}
	

	@Override
	public List<PostDTO> getPostByUserId(int userId) throws Exception
	{
		return postDAO.getPostByUserId(userId);
	}
	
	@Override
	public List<CommentDTO> getAllCommentsByPostId(int id) throws Exception
	{
		return commentDAO.getAllCommentsByPostId(id);
	}
	
	@Override
	public List<UserDTO> getUserById(int id) throws Exception
	{
		return userDAO.getUserById(id);
	}
	
	@Override
	public PostDTO fetchById(int id)
	{
		UserDTO user = new UserDTO();
		user.setUserId(123);
		user.setUserName("test user name");
		PostDTO post = new PostDTO();
		post.setPostId(id);
		post.setPostName("Test name");
		post.setPostContent("link to image");
		post.setDate(LocalDate.now());
		post.setUserId(1);
		return(post);
	}
	
	@Override
	public List<PostDTO> fetchPostList(int id)
	{
		List<PostDTO> postList = new ArrayList<PostDTO>();
		UserDTO user = new UserDTO();
		user.setUserId(123);
		user.setUserName("test user name");
		PostDTO post = new PostDTO();
		post.setPostId(id);
		post.setPostName("Test name");
		post.setPostContent("link to image");
		post.setDate(LocalDate.now());
		post.setUserId(1);
		postList.add(post);
		postList.add(post);
		return(postList);
	}

}
