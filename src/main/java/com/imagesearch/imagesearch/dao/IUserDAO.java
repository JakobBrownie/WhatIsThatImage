package com.imagesearch.imagesearch.dao;

import com.imagesearch.imagesearch.dto.UserDTO;

public interface IUserDAO {

	UserDTO save(UserDTO user);

	Iterable<UserDTO> fetchAll() throws Exception;

}