package com.zeus.backend.service;

import java.util.List;
import java.util.Map;

public interface SurveyService {
	public Map<String, Object> view(int survey_idx) throws Exception;

	public void insert(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> summary(int survey_idx) throws Exception;
}
