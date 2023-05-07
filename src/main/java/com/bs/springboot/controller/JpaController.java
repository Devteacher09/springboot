package com.bs.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.springboot.model.entity.JpaMember;
import com.bs.springboot.model.service.JpaService;

@RestController//Controller+ResponseBody 합쳐놓은 어노테이션
@RequestMapping("/jpa")
public class JpaController {

	//rest방식으로 요청받기
//	@GetMapping -> get방식으로 요청한 내용을 처리하는 메소드 -> 조회
//	@PostMapping -> post방식으로 요청한 내용을 처리하는 메소드 -> 저장(추가)
//	@PutMapping -> put방식으로 요청한 내용을 처리하는 메소드 -> 수정
//	@DeleteMapping -> delete방식으로 요청한 내용을 처리하는 메소드 -> 삭제
	
	private JpaService service;
	
	public JpaController(JpaService service) {
		this.service=service;
	}
	
	@GetMapping("/member")
	public List<JpaMember> selectMemberAll(){
		return service.selectMemberAll();
	}
	
	@GetMapping("/member/{id}")
	public JpaMember selectMemberById(@PathVariable String id) {
		return service.selectMemberById(id);
	}
	
	
	
	
	
}






