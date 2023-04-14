package com.imagesearch.imagesearch.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.imagesearch.imagesearch.dto.CommentDTO;
import com.imagesearch.imagesearch.dto.UserDTO;

public interface CommentRepository extends CrudRepository<CommentDTO, Integer> {

	List<CommentDTO> findByPostId(int postId);
}
