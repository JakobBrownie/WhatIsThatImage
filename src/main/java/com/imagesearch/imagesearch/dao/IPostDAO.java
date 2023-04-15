package com.imagesearch.imagesearch.dao;

import java.util.List;

import com.imagesearch.imagesearch.dto.PostDTO;

public interface IPostDAO {

	PostDTO save(PostDTO user);

	Iterable<PostDTO> fetchAll() throws Exception;

	List<PostDTO> getPostById(int id) throws Exception;

	List<PostDTO> getPostByUserId(int id) throws Exception;

}