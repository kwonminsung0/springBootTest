package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Board;
import com.zeus.mapper.BoardMapper;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Transactional
	@Override
	public void register(Board board) throws Exception {
		mapper.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		return mapper.read(boardNo);
	}

	@Transactional
	@Override
	public void modify(Board board) throws Exception {
		mapper.update(board);
	}

	@Transactional
	@Override
	public void remove(Integer boardNo) throws Exception {
		mapper.delete(boardNo);
	}

	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}
}
