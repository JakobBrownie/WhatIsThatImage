package com.imagesearch.imagesearch.service;

import java.time.LocalDate;

import com.imagesearch.imagesearch.dto.PostDTO;
import com.imagesearch.imagesearch.dto.UserDTO;

public class PostServiceStub {
	
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

}
