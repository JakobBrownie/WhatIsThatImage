package com.imagesearch.imagesearch.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.imagesearch.imagesearch.dto.UserDTO;

import com.imagesearch.imagesearch.dto.PostDTO;

public interface PostRepository extends CrudRepository<PostDTO, Integer> {

	List<PostDTO> findByUserId(int userId);
	
	List<PostDTO> findByPostId(int postId);
}
