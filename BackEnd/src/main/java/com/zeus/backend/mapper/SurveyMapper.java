package com.zeus.backend.mapper;

import java.util.List;
import java.util.Map;

public interface SurveyMapper {
	public Map<String, Object> view(int survey_idx) throws Exception;

	public void insert(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> summary(int survey_idx) throws Exception;
}
