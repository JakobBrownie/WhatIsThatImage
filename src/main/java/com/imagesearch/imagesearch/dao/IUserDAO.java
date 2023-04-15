package com.imagesearch.imagesearch.dao;

import java.util.List;

import com.imagesearch.imagesearch.dto.UserDTO;

public interface IUserDAO {

	UserDTO save(UserDTO user);

	Iterable<UserDTO> fetchAll() throws Exception;

	List<UserDTO> getUserById(int id) throws Exception;

}