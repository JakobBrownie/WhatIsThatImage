package com.imagesearch.imagesearch.service;

import java.util.List;

import com.imagesearch.imagesearch.dto.PostDTO;
import com.imagesearch.imagesearch.dto.UserDTO;

public interface IImageService {

	PostDTO fetchById(int id);

	List<PostDTO> fetchPostList(int id);
	
	UserDTO fetchUserById(int id);
	
	boolean save(UserDTO userDTO) throws Exception;

}