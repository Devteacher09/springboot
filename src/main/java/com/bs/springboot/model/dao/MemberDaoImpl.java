package com.bs.springboot.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bs.springboot.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> selectMemeberAll(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectMemberAll");
	}

	@Override
	public List<Member> selectMemberById(SqlSessionTemplate session, String id) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectMemberById",id);
	}

}
