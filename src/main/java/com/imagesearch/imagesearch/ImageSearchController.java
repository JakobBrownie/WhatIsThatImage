package com.imagesearch.imagesearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.imagesearch.imagesearch.dto.UserDTO;

import com.imagesearch.imagesearch.service.IImageService;

@Controller
public class ImageSearchController {
	
	@Autowired
	private IImageService imageService;

	
	@RequestMapping("/home")
	public String home()
	{
		
		return "home";
	}
	@RequestMapping(value="/login")
	public String login()
	{
		UserDTO user = new UserDTO();
		user = imageService.fetchUserById(10);
		
		try {
			Iterable<UserDTO> test = imageService.fetchAllUsers();
			imageService.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return "login";
	}
	@RequestMapping(value="/signup")
	public String signup()
	{
		
		return "signup";
	}
	@RequestMapping(value="/post")
	public String post()
	{
		
		return "post";
	}
	@RequestMapping(value="/newpost")
	public String newpost()
	{
		
		return "newpost";
	}
	@RequestMapping(value="/profile")
	public String profile()
	{
		
		return "profile";
	}
	@RequestMapping(value="/search")
	public String search()
	{
		
		return "search";
	}

}
