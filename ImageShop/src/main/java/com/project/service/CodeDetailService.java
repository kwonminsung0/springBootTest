package com.project.service;

import java.util.List;

import com.project.domain.CodeDetail;

public interface CodeDetailService {
	// 등록 처리
	public void register(CodeDetail codeDetail) throws Exception;

	// 목록 페이지
	public List<CodeDetail> list() throws Exception;
}
