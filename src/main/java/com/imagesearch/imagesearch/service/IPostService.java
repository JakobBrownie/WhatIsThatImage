package com.imagesearch.imagesearch.service;

import java.util.List;

import com.imagesearch.imagesearch.dto.PostDTO;

public interface IPostService {

	PostDTO fetchById(int id);

	List<PostDTO> fetchPostList(int id);

}