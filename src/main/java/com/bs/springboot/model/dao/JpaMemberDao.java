package com.bs.springboot.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.springboot.model.entity.JpaMember;

//boot에서 hibernate를 이용해서 sql문 처리하기
//인터페이스생성하기 -> jpaRepository인터페이스를 상속받음
@Repository
public interface JpaMemberDao extends JpaRepository<JpaMember,String>{
	
	//jparepository가 정해놓은 패턴에 의해서 메소드를 생성
	//select -> findBy필드명(필드명 데이터) -> 필드명과 일치하는 값을 조회하는 메소드 설정
	// 부분검색(like) -> findBy필드명Like(필드명데이터) -> 필드명을 like로 조회하는 메소드설정
	// 다수항목으로 조회 -> findBy필드명(And||Or)필드명(첫번째필드값,두번째필드값) -> 두개항목으로 조회하는 메소드설정
	// null -> findBy필드명IsNull||isNotNull()
	// 순서정렬해서 조회하기 findBy필드명OrderBy필드명(Asc||DESC)(필드값);
	List<JpaMember> findByUserNameLike(String name);
	
}








