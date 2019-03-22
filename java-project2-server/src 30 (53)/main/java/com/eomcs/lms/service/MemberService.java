package com.eomcs.lms.service;

import java.util.List;

import com.eomcs.lms.domain.Member;

public interface MemberService {
	
	List<Member> list(String searchWord);
	int add(Member member);
	Member get(int no);   // detail
	int update(Member member);
	int delete(int no);
	

}
