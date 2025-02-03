package com.zeus.backend.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.backend.mapper.MemoMapper;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	private MemoMapper mapper;

	@Override
	public List<Map<String, Object>> list(String memo) throws Exception {
		return mapper.list(memo);
	}

	@Transactional
	@Override
	public void insert(Map<String, Object> map) throws Exception {
		mapper.insert(map);
	}

	@Override
	public Map<String, Object> detail(int idx) throws Exception {

		return mapper.detail(idx);
	}

	@Transactional
	@Override
	public void update(Map<String, Object> map) throws Exception {
		mapper.update(map);

	}

	@Transactional
	@Override
	public void delete(int idx) throws Exception {
		mapper.delete(idx);

	}

}
