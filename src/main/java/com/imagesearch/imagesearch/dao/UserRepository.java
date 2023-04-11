package com.imagesearch.imagesearch.dao;

import org.springframework.data.repository.CrudRepository;

import com.imagesearch.imagesearch.dto.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, Integer> {

}
