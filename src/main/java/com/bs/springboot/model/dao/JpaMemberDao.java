package com.bs.springboot.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.springboot.model.entity.JpaMember;

//boot에서 hibernate를 이용해서 sql문 처리하기
//인터페이스생성하기 -> jpaRepository인터페이스를 상속받음
@Repository
public interface JpaMemberDao extends JpaRepository<JpaMember,String>{

}
