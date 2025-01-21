package com.project.mapper;

import java.util.List;

import com.project.common.domain.CodeLabelValue;

public interface CodeMapper {
	// 그룹코드 목록 조회
	public List<CodeLabelValue> getCodeGroupList() throws Exception;
}
