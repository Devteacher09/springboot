package com.bs.springboot.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bs.springboot.model.dao.JpaBoardDao;
import com.bs.springboot.model.dao.JpaMemberDao;
import com.bs.springboot.model.entity.JpaBoard;
import com.bs.springboot.model.entity.JpaMember;
import com.bs.springboot.model.vo.Member;

@Service
public class JpaServiceImpl implements JpaService {
	
	private JpaMemberDao dao;
	private JpaBoardDao boardDao;
	
	public JpaServiceImpl(JpaMemberDao dao, JpaBoardDao boardDao) {
		this.dao=dao;
		this.boardDao=boardDao;
	}
	
	@Override
	public List<JpaMember> selectMemberAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	//페이징처리한 데이터 가져오기
	public Page<JpaMember> selectMemberPage(){
		return dao.findAll(PageRequest.of(0,5,Sort.by("userId").ascending()));
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
		return boardDao.findAll();
	}

	@Override
	public JpaBoard selectBoard(Long id) {
		// TODO Auto-generated method stub
		return boardDao.findById(id).orElse(JpaBoard.builder().build());
	}

	@Override
	public List<JpaBoard> selectBoardByContent(String keyword) {
		// TODO Auto-generated method stub
		return boardDao.findByBoardContentLike("%"+keyword+"%");
	}

	@Override
	public JpaBoard insertBoard(JpaBoard board,String boardWriter) {
		// TODO Auto-generated method stub
		JpaMember m=dao.findById(boardWriter).orElseThrow();
		board.setWriter(m);
		return boardDao.save(board);
	}

	
	
}
