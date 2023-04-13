package com.imagesearch.imagesearch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imagesearch.imagesearch.dto.UserDTO;

@Component
public class UserDAO implements IUserDAO {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDTO save(UserDTO user)
	{
		userRepository.save(user);
		return user;
	}
	
	@Override
	public Iterable<UserDTO> fetchAll() throws Exception
	{
		return userRepository.findAll();
	}
	
}
