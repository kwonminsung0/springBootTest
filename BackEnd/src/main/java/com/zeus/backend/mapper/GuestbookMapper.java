package com.zeus.backend.mapper;

import java.util.List;
import java.util.Map;

public interface GuestbookMapper {
	public List<Map<String, Object>> list_all(String search) throws Exception;

	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception;

	public void insert(Map<String, Object> map) throws Exception;

	public Map<String, Object> detail(int idx) throws Exception;

	public int check_pwd(Map<String, Object> map) throws Exception;

	public void update(Map<String, Object> map) throws Exception;

	public void delete(int idx) throws Exception;
}
