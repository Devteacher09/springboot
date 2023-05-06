package com.bs.springboot.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.bs.springboot.model.vo.Member;

public interface MemberDao {
	
	List<Member> selectMemeberAll(SqlSessionTemplate session);
	
	List<Member> selectMemberById(SqlSessionTemplate Session, String id);
}
