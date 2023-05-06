package com.bs.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bs.springboot.model.service.MemberService;
import com.bs.springboot.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
//@CrossOrigin
public class BasicController {
	
	@Value("${linux.base}")
	private String linuxBaseDir;
	
	
	private MemberService service;
	//springframework 4.2버전이 이후에는 매개변수있는 생성자 한개만 있는경우
	// @Auwired어노테이션을 설정하지 않아도 자동으로 주입해준다.
	//@Autowired
	public BasicController(MemberService service) {
		this.service=service;
	}
	
//	@RequestMapping("/")
//	@ResponseBody
//	public Test index() {
//		return new Test("boot",2);
//	}
	
	@RequestMapping("/member")
	@ResponseBody
	public List<Member> selectMemberAll(){
		List<Member> list=service.selectMemberAll();
		log.info("{}",list);
		return list;
		
	}
	
//	@RequestMapping("/")
//	public String index() {
//		log.info("linuxBaseDir : "+linuxBaseDir);
//		return "index";
//	}
	
	@RequestMapping("/member/memberAll.do")
	public String selectMemberAll2(Model model) {
		
		List<Member> list=service.selectMemberAll();
		model.addAttribute("members",list);
		
		return "member/memberList";
	}
	
	@RequestMapping("/member/searchMember.do")
	public String searchMember(Model model, String id) {
		log.info("id : "+id);
		List<Member> list=service.selectMemberById(id);
		model.addAttribute("members",list);
		return "member/memberList";
	}
	
	
	@RequestMapping("/fileupload")
	public String uploadFile(MultipartFile upfile) {
		log.info("파일크기 : "+upfile.getSize());
		log.info("파일크기 : "+upfile.getOriginalFilename());
		
		return "redirect:/"; 
		
	}
	
	
	
}



