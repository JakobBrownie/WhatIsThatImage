package com.imagesearch.imagesearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageSearchController {

	
	@RequestMapping("/home")
	public String home()
	{
		
		return "home";
	}
}
