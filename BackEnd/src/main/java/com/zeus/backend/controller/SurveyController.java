package com.zeus.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.backend.service.SurveyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SurveyController {

	@Autowired
	private SurveyService service;

	@RequestMapping("/survey/view/{survey_idx}")
	public Map<String, Object> view(@PathVariable(name = "survey_idx") int survey_idx) throws Exception {
		log.info("survey/view/{survey_idx}=" + survey_idx);
		return service.view(survey_idx);
	}

	@RequestMapping("/survey/insert")
	public void insert(@RequestParam Map<String, Object> map) throws Exception {
		System.out.println(map);
		service.insert(map);
	}

	@RequestMapping("/survey/summary/{survey_idx}")
	public List<Map<String, Object>> summary(@PathVariable(name = "survey_idx") int survey_idx) throws Exception {
		log.info("survey_idx=" + survey_idx);
		return service.summary(survey_idx);
	}
}
