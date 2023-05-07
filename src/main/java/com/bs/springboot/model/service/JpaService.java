package com.bs.springboot.model.service;

import java.util.List;

import com.bs.springboot.model.entity.JpaBoard;
import com.bs.springboot.model.entity.JpaMember;

public interface JpaService {

	List<JpaMember> selectMemberAll();
	JpaMember selectMemberById(String id);
	
	List<JpaBoard> selectBoardAll();
	JpaBoard selectBoard(Long id);
	List<JpaBoard> selectBoardByContent(String keyword);
	
	
	
	
}