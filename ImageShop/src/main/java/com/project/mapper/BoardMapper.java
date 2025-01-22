package com.project.mapper;

import java.util.List;

import com.project.domain.Board;

public interface BoardMapper {
	// 게시글 등록 처리
	public void create(Board board) throws Exception;

	// 게시글 목록 페이지
	public List<Board> list() throws Exception;
}
