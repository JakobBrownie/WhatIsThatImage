package com.imagesearch.imagesearch.dao;

import java.util.List;

import com.imagesearch.imagesearch.dto.CommentDTO;

public interface ICommentDAO {

	CommentDTO save(CommentDTO user);

	Iterable<CommentDTO> fetchAll() throws Exception;

	List<CommentDTO> getAllCommentsByPostId(int id) throws Exception;

}