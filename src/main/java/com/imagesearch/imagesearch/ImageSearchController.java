package com.imagesearch.imagesearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.imagesearch.imagesearch.dto.UserDTO;
import com.imagesearch.imagesearch.dao.ICommentDAO;
import com.imagesearch.imagesearch.dao.IPostDAO;
import com.imagesearch.imagesearch.dao.IUserDAO;
import com.imagesearch.imagesearch.dto.CommentDTO;
import com.imagesearch.imagesearch.dto.PostDTO;
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
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
	@RequestMapping(value="/login")
	public String login(Model model)
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
	public ModelAndView post(@RequestParam("post_Id") int postId)
	{
		ModelAndView modelAndView = new ModelAndView();
		List<PostDTO> posts = new ArrayList<PostDTO>();
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		try {
			posts = imageService.getPostById(postId);
			comments = imageService.getAllCommentsByPostId(postId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelAndView.setViewName("error");
		}
		PostDTO post = posts.get(0);
		
		modelAndView.setViewName("post");
		modelAndView.addObject("post", post);
		modelAndView.addObject("comments", comments);
		
		return modelAndView;
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
	public ModelAndView search(@RequestParam(value ="searchTerm", required = false, defaultValue="") String searchTerm)
	{
		ModelAndView modelAndView = new ModelAndView();
		List<PostDTO> posts = new ArrayList<PostDTO>();
		try {						
			posts= 
					StreamSupport.stream(imageService.fetchAllPosts().spliterator(), false)
					.collect(Collectors.toList());
		}catch (Exception e)
		{
			e.printStackTrace();
			modelAndView.setViewName("error");
		}
		List<PostDTO> resultPosts = new ArrayList<PostDTO>();
		for(PostDTO post: posts)
		{
			if( post.getPostName().contains(searchTerm))
			{
				resultPosts.add(post);
			}
		}
		modelAndView.setViewName("search");
		modelAndView.addObject("posts", resultPosts);
		return modelAndView;
	}

}
