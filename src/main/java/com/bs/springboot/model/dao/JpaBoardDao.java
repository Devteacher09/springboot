package com.bs.springboot.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.springboot.model.entity.JpaBoard;

@Repository
public interface JpaBoardDao extends JpaRepository<JpaBoard,Long>{
	List<JpaBoard> findByBoardContentLike(String content);
}




