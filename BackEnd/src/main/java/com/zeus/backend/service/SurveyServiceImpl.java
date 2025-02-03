package com.zeus.backend.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.backend.mapper.SurveyMapper;

@Service
public class SurveyServiceImpl implements SurveyService {
	@Autowired
	private SurveyMapper mapper;

	@Override
	public Map<String, Object> view(int survey_idx) throws Exception {
		return mapper.view(survey_idx);
	}

	@Transactional
	@Override
	public void insert(Map<String, Object> map) throws Exception {
		mapper.insert(map);
	}

	@Override
	public List<Map<String, Object>> summary(int survey_idx) throws Exception {
		return mapper.summary(survey_idx);
	}

}
