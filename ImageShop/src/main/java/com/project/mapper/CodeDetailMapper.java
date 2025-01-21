package com.project.mapper;

import java.util.List;

import com.project.domain.CodeDetail;

public interface CodeDetailMapper {
	// 등록 처리
	public void create(CodeDetail codeDetail) throws Exception;

	// 그룹코드 정렬 순서의 최대값
	public Integer getMaxSortSeq(String groupCode) throws Exception;

	// 목록 페이지
	public List<CodeDetail> list() throws Exception;
}
