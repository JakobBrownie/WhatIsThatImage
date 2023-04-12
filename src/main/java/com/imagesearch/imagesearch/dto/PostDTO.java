package com.imagesearch.imagesearch.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PostDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	private String postName;
	private String postContent;
	private UserDTO user;
	private LocalDate date;
	
	public int getpostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getpostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public UserDTO getTestName() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public LocalDate getDate()
	{
		return date;
	}
	public void setDate(LocalDate date)
	{
		this.date = date;
	}

}
