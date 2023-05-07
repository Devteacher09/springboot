package com.bs.springboot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.springboot.model.entity.JpaBoard;
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
	private BCryptPasswordEncoder pwEncoder=new BCryptPasswordEncoder();
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
	
	@PostMapping("/member")
	public JpaMember insertMember(HttpServletRequest request,JpaMember member) {
		System.out.println(member);
		member.setPassword(pwEncoder.encode(member.getPassword()));
		return service.insertMember(member);
	}
	
	@GetMapping("/member/name/{name}")
	public List<JpaMember> selectMemberByName(@PathVariable String name){
		return service.selectMemberByName(name);
	}
	
	@GetMapping("/member/page")
	public Page<JpaMember> selectMemberPage(){
		return service.selectMemberPage();
	}
	
	@GetMapping("/board")
	public ResponseEntity<List<JpaBoard>> selectBoard(){
		List<JpaBoard> boards=service.selectBoardAll();
		ResponseEntity<List<JpaBoard>> response
			=new ResponseEntity<>(boards,HttpStatus.OK);
		return response;
	}
	@GetMapping("/board/content")
	public ResponseEntity<List<JpaBoard>> selectBoarByContent(String content){
		List<JpaBoard> boards=service.selectBoardByContent(content);
		ResponseEntity<List<JpaBoard>> response
			=new ResponseEntity<>(boards,HttpStatus.OK);
		return response;
	}
	@PostMapping("/board")
	public ResponseEntity<Boolean> insertBoard(JpaBoard board,String boardWriter){
		board.setBoardDate(new Date());
		JpaBoard result=service.insertBoard(board,boardWriter);
		ResponseEntity<Boolean> response
			=new ResponseEntity<>((result==null?false:true),HttpStatus.OK);
		return response;
	}
}






