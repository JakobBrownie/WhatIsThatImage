package com.imagesearch.imagesearch.dao;

import com.imagesearch.imagesearch.dto.CommentDTO;

public interface ICommentDAO {

	CommentDTO save(CommentDTO user);

	Iterable<CommentDTO> fetchAll() throws Exception;

}