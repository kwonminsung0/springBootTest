package com.zeus.backend.service;

import java.util.List;
import java.util.Map;

public interface GuestbookService {
	public List<Map<String, Object>> list(String searchkey, String search) throws Exception;

	public void insert(Map<String, Object> map) throws Exception;

	public Map<String, Object> detail(int idx) throws Exception;

	public boolean check_pwd(int idx, String passwd) throws Exception;

	public void update(Map<String, Object> map) throws Exception;

	public void delete(int idx) throws Exception;
}
