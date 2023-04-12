package com.imagesearch.imagesearch.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import com.imagesearch.imagesearch.dao.IUserDAO;
import com.imagesearch.imagesearch.dto.PostDTO;
import com.imagesearch.imagesearch.dto.UserDTO;

@Component
public class ImageService implements IImageService {
	
	@Autowired
	IUserDAO userDAO;
	
	public boolean save(UserDTO userDTO) throws Exception
	{
		userDAO.save(userDTO);
		return false;
	}
	
	@Override
	public UserDTO fetchUserById(int id)
	{
		UserDTO user = new UserDTO();
		user.setUserId(123);
		user.setUserName("test user name");
		return(user);
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
		post.setUser(user);
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
		post.setUser(user);
		postList.add(post);
		postList.add(post);
		return(postList);
	}

}
