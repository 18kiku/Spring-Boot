package com.springbook.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.entity.BoardDTO;
import com.springbook.repository.BoardRepository;
import com.springbook.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	/*
	// 화면을 보여줄때는 get방식으로
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoard() {
		System.out.println("=> BoardController - 글등록 화면 이동");
		return "insertBoard";
	}
	// 처리할때는 post방식으로 나눠주자
	@PostMapping(value="/insertBoard")
	public String insertBoard(BoardDTO dto) throws IOException{
		System.out.println("=> BoardController - 글등록 처리(처리)");
		boardService.insertBoard(dto);
		
		if(dto.getTitle().equals("")) return "insertBoard";
		if(dto.getWriter().equals("")) return "insertBoard";
		if(dto.getContent().equals("")) return "insertBoard";
		
		return "redirect:getBoardList";
	}
	// SessionAttributes의 ModelAttribute 어노테이션을 사용하여 update할때 발생하는 null 업데이트를 방지
	@RequestMapping(value="/updateBoard")
	public String updateBoard(@ModelAttribute("board") BoardDTO dto){
		System.out.println("=> BoardController - 글수정 처리");
		System.out.println("작성자 : " + dto.getWriter());
		boardService.updateBoard(dto);
		return "redirect:getBoardList";
	}
	@RequestMapping(value="/deleteBoard")
	public String deleteBoard(BoardDTO dto) {
		System.out.println("=> BoardController - 글삭제 처리");
		boardService.deleteBoard(dto);
		return "redirect:getBoardList";
	}
	
	
	@RequestMapping(value="/getBoard")
	public String getBoard(BoardDTO dto, Model model) {
		System.out.println("=> BoardController - 글상세 조회");
		model.addAttribute("board", boardService.getBoard(dto));
		return "getBoard";
	}
	// 검색 목록 설정
	@ModelAttribute("conditionMap") // RequestMapping 이전에 실행
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("작성자", "WRITER");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	/*	
	@RequestMapping(value="/getBoardList")
	public String getBoardList(BoardDTO dto, Model model) {
		System.out.println("=> BoardController - 글목록 조회");
			
		// 검색 확인 - searchCondition, searchKeyword가 null일때의 처리
		if(dto.getSearchCondition() == null) dto.setSearchCondition("TITLE");
		if(dto.getSearchKeyword() == null) dto.setSearchKeyword("");
		 
		
		model.addAttribute("boardList", boardService.getBoardList(dto));
		return "getBoardList";
	}
	*/
	@Autowired
	BoardRepository boardRepository;
	
	@RequestMapping(value="/getBoardList")
	public String getBoardList(BoardDTO dto, Model model) {
		System.out.println("=> BoardController - 글목록 조회");
			
		// 검색 확인 - searchCondition, searchKeyword가 null일때의 처리
		if(dto.getSearchCondition() == null) dto.setSearchCondition("TITLE");
		if(dto.getSearchKeyword() == null) dto.setSearchKeyword("");
		 
		
		model.addAttribute("boardList", boardService.getBoardList(dto));
		return "getBoardList";
	}
	@RequestMapping(value="/getBoard")
	public String getBoard(BoardDTO dto, Model model) {
		System.out.println("=> BoardController - 글상세 조회");
		model.addAttribute("board", boardService.getBoard(dto));
		return "getBoard";
	}
}
