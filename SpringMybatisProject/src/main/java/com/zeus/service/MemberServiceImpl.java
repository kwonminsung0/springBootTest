package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;
import com.zeus.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Transactional
	@Override
	//삽입요청
	public void register(Member member) throws Exception {
		//회원정보삽입
		mapper.create(member);
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");
		//회원권한삽입
		mapper.createAuth(memberAuth);
	}

	@Override
	//회원정보요청
	public Member read(int userNo) throws Exception {
		return mapper.read(userNo);
	}

	@Transactional
	@Override
	//회원정보수정
	public void modify(Member member) throws Exception {
		mapper.update(member);

		//회원권한삭제
		int userNo = member.getUserNo();
		mapper.deleteAuth(userNo);
		//회원권한 가져오기
		List<MemberAuth> authList = member.getAuthList();
		
		for (int i = 0; i < authList.size(); i++) {
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			if (auth == null) {
				continue;
			}
			if (auth.trim().length() == 0) {
				continue;
			}
			memberAuth.setUserNo(userNo);
			mapper.createAuth(memberAuth);
		}
	}

	@Transactional
	@Override
	//회원삭제
	public void remove(int userNo) throws Exception {
		mapper.deleteAuth(userNo); // 삭제 순서
		mapper.delete(userNo);
	}

	@Override
	//회원리스트
	public List<Member> list() throws Exception {
		return mapper.list();
	}

}
