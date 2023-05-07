package com.bs.springboot.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bs.springboot.model.dao.JpaMemberDao;
import com.bs.springboot.model.entity.JpaBoard;
import com.bs.springboot.model.entity.JpaMember;

@Service
public class JpaServiceImpl implements JpaService {
	
	private JpaMemberDao dao;
	
	public JpaServiceImpl(JpaMemberDao dao) {
		this.dao=dao;
	}
	
	@Override
	public List<JpaMember> selectMemberAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public JpaMember selectMemberById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(JpaMember.builder().build());
	}
	
	
	@Override
	public List<JpaMember> selectMemberByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByUserNameLike("%"+name+"%");
	}

	@Override
	public JpaMember insertMember(JpaMember m) {
		// TODO Auto-generated method stub
		return dao.save(m);
	}

	@Override
	public List<JpaBoard> selectBoardAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JpaBoard selectBoard(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JpaBoard> selectBoardByContent(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
