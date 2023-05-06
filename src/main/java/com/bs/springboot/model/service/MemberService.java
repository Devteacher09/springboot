package com.bs.springboot.model.service;

import java.util.List;

import com.bs.springboot.model.vo.Member;

public interface MemberService {
	
	List<Member> selectMemberAll();
	
	List<Member> selectMemberById(String id);
	
}
