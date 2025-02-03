package com.zeus.backend.mapper;

import java.util.List;
import java.util.Map;

public interface MemoMapper {
	public List<Map<String, Object>> list(String memo) throws Exception;

	public void insert(Map<String, Object> map) throws Exception;

	public Map<String, Object> detail(int idx) throws Exception;

	public void update(Map<String, Object> map) throws Exception;

	public void delete(int idx) throws Exception;
}
