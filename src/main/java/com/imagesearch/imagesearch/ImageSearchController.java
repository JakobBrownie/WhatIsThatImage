package com.imagesearch.imagesearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
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

import jakarta.servlet.http.HttpSession;

@Controller
public class ImageSearchController {
	
	@Autowired
	private IImageService imageService;

	private Boolean islogin = false;
	private int loginUserId = 0;
	//default nav
	@RequestMapping("/home")
	public String home()
	{
		
		return "home";
	}
	//backup navigation
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	
	//nav checks if user is logged in/otherwise goes to login
	@RequestMapping(value="/login")
	public String login()
	{
		String returnString = "home";
		if(islogin == true)
		{
			returnString = "redirect:/profile?user_Id=" + loginUserId;
			
		} else
		{
			returnString = "login";
		}
		return returnString;
	}
	//initial sign up page nav
	@RequestMapping(value="/signup")
	public String signup()
	{
		
		return "signup";
	}
	//after clicking sign up nav
	@RequestMapping(value="/aftersignup")
	public String aftersignup(@RequestParam(value ="username", required = true) String username, @RequestParam(value ="password", required = true) String password)
	{
		String returnString = "signup";
		UserDTO user = new UserDTO();
		user.setUserName(username);
		user.setPassword(password);
		try {
			imageService.save(user);
			returnString = "login";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnString;
	}
	//after clicking login nav
	@RequestMapping(value="/afterLogin")
	public String afterLogin(@RequestParam(value ="username", required = true) String username, @RequestParam(value ="password", required = true) String password)
	{
		String returnString = "login";
		List<UserDTO> users = new ArrayList<UserDTO>();
		try {
		users= 
				StreamSupport.stream(imageService.fetchAllUsers().spliterator(), false)
				.collect(Collectors.toList());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		for(UserDTO user: users)
		{		
			if (user.getUserName().equals(username) && user.getPassword().equals(password))
			{
				loginUserId= user.getUserId();
				islogin = true;
				return "redirect:/profile?user_Id=" + loginUserId;
			} else
			{
				returnString = "redirect:/login?fail=True";
			}
		}
		return returnString;
	}
	// post nav to show any given post
	@RequestMapping(value="/post")
	public ModelAndView post(@RequestParam("post_Id") int postId)
	{
		ModelAndView modelAndView = new ModelAndView();
		List<PostDTO> posts = new ArrayList<PostDTO>();
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		//get all posts with id and comments related to the post
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
	
	//new post checks if user is logged in then if not forces log in
	@RequestMapping(value="/newpost")
	public String newpost()
	{
		String returnString = "login";
	   if(islogin == true)
	   {
		   returnString = "newpost";
	   }
		return returnString;
	}
	
	//after create post screen, creates and saves new post
	@RequestMapping(value="/afternewpost")
	public String afternewpost(@RequestParam(value ="postname", required = true) String postname, @RequestParam(value ="imagelink", required = true) String imagelink)
	{
	   PostDTO post = new PostDTO();
	   post.setPostName(postname);
	   post.setPostContent(imagelink);
	   post.setDate(LocalDate.now());
	   post.setUserId(loginUserId);
	   
	   //get user to add user name to post
	   UserDTO user = new UserDTO();
		try {
			user = imageService.getUserById(loginUserId).get(0);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		post.setUserName(user.getUserName());
	   try {
		imageService.savePost(post);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
		return "redirect:/profile?user_Id=" + loginUserId;
	}
	
	//if not current user profile
	@RequestMapping(value="/profile")
	public ModelAndView profile(@RequestParam("user_Id") int userId)
	{
		ModelAndView modelAndView = new ModelAndView();
		UserDTO user = new UserDTO();
		try {
			user = imageService.getUserById(userId).get(0);
			modelAndView.setViewName("profile");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelAndView.setViewName("home");
		}
		
		//gets all posts by the user being shown
		List<PostDTO> posts = new ArrayList<PostDTO>();
		try {						
			posts= imageService.getPostByUserId(userId);
		}catch (Exception e)
		{
			e.printStackTrace();
			modelAndView.setViewName("error");
		}	
		modelAndView.addObject("posts", posts);			
		modelAndView.addObject("user", user);		
		return modelAndView;
	}
	
	@RequestMapping(value="/userprofile")
	public String userprofile()
	{			
		return "redirect:/profile?user_Id=" + loginUserId;
	}
	//displays top results from search
	@RequestMapping(value="/search")
	public ModelAndView search(@RequestParam(value ="searchTerm", required = false, defaultValue="") String searchTerm)
	{
		ModelAndView modelAndView = new ModelAndView();
		List<PostDTO> posts = new ArrayList<PostDTO>();
		//get posts
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
