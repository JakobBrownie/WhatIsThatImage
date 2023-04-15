package com.imagesearch.imagesearch.service;

import java.util.List;

import com.imagesearch.imagesearch.dto.CommentDTO;
import com.imagesearch.imagesearch.dto.PostDTO;
import com.imagesearch.imagesearch.dto.UserDTO;

public interface IImageService {

	PostDTO fetchById(int id);

	List<PostDTO> fetchPostList(int id);
	
	UserDTO fetchUserById(int id);
	
	boolean save(UserDTO userDTO) throws Exception;

	Iterable<UserDTO> fetchAllUsers() throws Exception;

	Iterable<CommentDTO> fetchAllComments() throws Exception;

	Iterable<PostDTO> fetchAllPosts() throws Exception;

	List<PostDTO> getPostById(int id) throws Exception;

	List<CommentDTO> getAllCommentsByPostId(int id) throws Exception;

	List<UserDTO> getUserById(int id) throws Exception;

	List<PostDTO> getPostByUserId(int userId) throws Exception;

}