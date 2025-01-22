package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.Board;
import com.project.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;

	// 게시글 등록 처리
	@Override
	public void register(Board board) throws Exception {
		mapper.create(board);
	}

	// 게시글 목록 페이지
	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}
}
