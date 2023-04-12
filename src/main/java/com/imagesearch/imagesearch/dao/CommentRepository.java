package com.imagesearch.imagesearch.dao;

import org.springframework.data.repository.CrudRepository;

import com.imagesearch.imagesearch.dto.CommentDTO;

public interface CommentRepository extends CrudRepository<CommentDTO, Integer> {

}
