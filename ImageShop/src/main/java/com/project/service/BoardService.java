package com.project.service;

import java.util.List;

import com.project.domain.Board;

public interface BoardService {
	// 게시글 등록 처리
	public void register(Board board) throws Exception;

	// 게시글 목록 페이지
	public List<Board> list() throws Exception;
}
