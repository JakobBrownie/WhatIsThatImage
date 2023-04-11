package com.imagesearch.imagesearch.dao;

import com.imagesearch.imagesearch.dto.UserDTO;

public class UserDAO implements IUserDAO {

	@Override
	public UserDTO save(UserDTO user)
	{
		UserDTO testuser = new UserDTO();
		return user;
	}
	
}
