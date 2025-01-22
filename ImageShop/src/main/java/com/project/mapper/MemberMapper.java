package com.project.mapper;

import com.project.domain.Member;
import com.project.domain.MemberAuth;

public interface MemberMapper {

	// 등록 처리
	public void create(Member member) throws Exception;

	// 권한 생성
	public void createAuth(MemberAuth memberAuth) throws Exception;
}
