package com.bs.springboot.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bs.springboot.model.entity.JpaBoard;
import com.bs.springboot.model.entity.JpaMember;

public interface JpaService {

	List<JpaMember> selectMemberAll();
	JpaMember selectMemberById(String id);
	JpaMember insertMember(JpaMember m);
	List<JpaMember> selectMemberByName(String name);
	Page<JpaMember> selectMemberPage();
	
	
	List<JpaBoard> selectBoardAll();
	JpaBoard selectBoard(Long id);
	List<JpaBoard> selectBoardByContent(String keyword);
	JpaBoard insertBoard(JpaBoard board,String boardWriter);
	
	
	
	
}
