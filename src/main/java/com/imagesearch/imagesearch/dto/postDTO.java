package com.imagesearch.imagesearch.dto;

public class postDTO {
	
	private int postId;
	private String postName;
	private String postContent;
	private userDTO user;
	
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
	public userDTO getTestName() {
		return user;
	}
	public void setUser(userDTO user) {
		this.user = user;
	}

}
