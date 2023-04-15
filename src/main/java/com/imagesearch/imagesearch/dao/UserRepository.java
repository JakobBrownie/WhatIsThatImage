package com.imagesearch.imagesearch.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.imagesearch.imagesearch.dto.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, Integer> {
	List<UserDTO> findUserByUserId(int id);
	
}
