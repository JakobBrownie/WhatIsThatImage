package com.imagesearch.imagesearch.dao;

import org.springframework.data.repository.CrudRepository;

import com.imagesearch.imagesearch.dto.PostDTO;

public interface PostRepository extends CrudRepository<PostDTO, Integer> {

}
