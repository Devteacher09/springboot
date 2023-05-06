package com.bs.springboot.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bs.springboot.model.dao.MemberDao;
import com.bs.springboot.model.mapper.MemberMapper;
import com.bs.springboot.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	private SqlSessionTemplate session;
	private MemberDao dao;
	private MemberMapper memberMapper;
	
	
	public MemberServiceImpl(SqlSessionTemplate session,MemberDao dao,
				MemberMapper memberMapper) {
		this.session=session;
		this.dao=dao;
		this.memberMapper=memberMapper;
	}
	
	
	@Override
	public List<Member> selectMemberAll() {
		// TODO Auto-generated method stub
		//return dao.selectMemeberAll(session);
		return memberMapper.selectMember();
	}

	@Override
	public List<Member> selectMemberById(String id) {
		// TODO Auto-generated method stub
//		return dao.selectMemberById(session, id);
		return memberMapper.selectMemberById(id);
	}

}
