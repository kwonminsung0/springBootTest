package com.zeus.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.backend.mapper.GuestbookMapper;

@Service
public class GuestbookServiceImpl implements GuestbookService {

	@Autowired
	private GuestbookMapper mapper;

	@Override
	public List<Map<String, Object>> list(String searchkey, String search) throws Exception {
		if (searchkey.equals("name_contents")) {
			return mapper.list_all("%" + search + "%");
		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("searchkey", searchkey);
			map.put("search", "%" + search + "%");
			return mapper.list(map);
		}
	}

	@Override
	public void insert(Map<String, Object> map) throws Exception {
		mapper.insert(map);
	}

	@Override
	public Map<String, Object> detail(int idx) throws Exception {
		return mapper.detail(idx);
	}

	@Override
	public boolean check_pwd(int idx, String passwd) throws Exception {
		boolean result = false;
		Map<String, Object> map = new HashMap<>();
		map.put("idx", idx);
		map.put("passwd", passwd);
		int count = mapper.check_pwd(map);
		result = count == 1 ? true : false;
		return result;
	}

	@Override
	public void update(Map<String, Object> map) throws Exception {
		mapper.update(map);
	}

	@Override
	public void delete(int idx) throws Exception {
		mapper.delete(idx);
	}

}
