package com.imagesearch.imagesearch.dao;

import com.imagesearch.imagesearch.dto.PostDTO;

public interface IPostDAO {

	PostDTO save(PostDTO user);

	Iterable<PostDTO> fetchAll() throws Exception;

}