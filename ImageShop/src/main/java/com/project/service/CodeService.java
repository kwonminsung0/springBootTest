package com.project.service;

import java.util.List;

import com.project.common.domain.CodeLabelValue;

public interface CodeService {
	
	// 그룹코드 목록 조회
	public List<CodeLabelValue> getCodeGroupList() throws Exception;
}
