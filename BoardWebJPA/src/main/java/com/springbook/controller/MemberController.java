package com.springbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.entity.MemberDTO;
import com.springbook.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	// 로그인 폼으로 화면이동 -> GET
	//@RequestMapping(value="/login", method=RequestMethod.GET)
	@GetMapping(value="/login")
	public String login(HttpSession session) {
		System.out.println("=> MemberController - 로그인 화면이동");
		session.invalidate();
		return "login";
	}
	// 로그인 처리(DB 처리) -> POST
	//@RequestMapping(value="/login", method=RequestMethod.POST)
	@PostMapping(value="/login")
	public String login(MemberDTO dto, HttpSession session) {
		System.out.println("=> MemberController - 로그인 처리(DB 처리)");
		
		if(dto.getId().equals("")) {
			return "login";
		}
		if(dto.getPassword().equals("")) {
			return "login";
		}
		MemberDTO member = memberService.loginMember(dto);
		if(member != null) {
			session.setAttribute("member", member);
			return "redirect:getBoardList";
		}
		else return "login";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		System.out.println("=> MemberController - 로그아웃 처리");
		session.invalidate();
		return "redirect:login";
	}
	
	// ######################
	// 회원가입, 수정, 삭제, 상세확인
	@GetMapping("/insertMember")
	public String insertMember() {
		System.out.println("=> MemberController - 회원가입화면 이동");
		return "insertMember";
	}
	@RequestMapping("/checkIdMember")
	public String checkIdMember(MemberDTO dto, Model model, HttpSession session){
		System.out.println("=> MemberController - 회원 아이디 중복 체크");
		
		session.setAttribute("checkId", dto.getId());
		session.setAttribute("checkMember", memberService.checkIdMember(dto));
		model.addAttribute("member", memberService.checkIdMember(dto));
		return "insertMember";
	}
	@PostMapping("/insertMember")
	public String insertMember(MemberDTO dto) {
		System.out.println("=> MemberController - 회원등록 처리(DB)");
		
		if(dto.getId().equals("")) return "insertMember";
		if(dto.getPassword().equals("")) return "insertMember";
		if(dto.getName().equals("")) return "insertMember";
		if(dto.getEmail().equals("")) return "insertMember";
		if(dto.getTel().equals("")) return "insertMember";
		if(dto.getAddress().equals("")) return "insertMember";
		
		memberService.insertMember(dto);
		return "login";
	}
	@RequestMapping("/updateMember")
	public String updateMember(MemberDTO dto){
		System.out.println("=> MemberController - 회원정보 업데이트");
		memberService.updateMember(dto);
		return "getMember";
	}
	@RequestMapping("/deleteMember")
	public String deleteMember(MemberDTO dto) {
		System.out.println("=> MemberController - 회원탈퇴");
		memberService.deleteMember(dto);
		return "login";
	}
	@RequestMapping("/getMember")
	public String getMember(MemberDTO dto, Model model) {
		System.out.println("=> MemberController - 회원정보확인");
		model.addAttribute("member", memberService.getMember(dto));
		return "getMember";
	}
}
