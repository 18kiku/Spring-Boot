package com.springbook.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.springbook.entity.BoardDTO;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class BoardRepositoryTest{

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	@DisplayName("게시판 새글 저장 테스트")
	public void createBoardTest() {
		/*
		BoardDTO board = new BoardDTO();
		board.setTitle("스프링부트테스트");
		board.setWriter("부트");
		board.setContent("테스트중");
		board.setRegdate(LocalDateTime.now());
		BoardDTO savedBoard = boardRepository.save(board);
		System.out.println(savedBoard);
		*/
		String[] wsg = {"윤은혜", "나비", "이보람", "코타", "박진주", "조현아",
				"쏠", "소연", "엄지윤", "권진아", "횐", "정지소"
		};
				
		for(int i=0; i<12; i++) {
			BoardDTO board = new BoardDTO();
			board.setTitle("WSG 워너비 : " + (i+1) +"번째 멤버");
			board.setWriter(wsg[i]);
			board.setContent("wsg 워너비");
			board.setRegdate(LocalDateTime.now());
			BoardDTO savedBoard = boardRepository.save(board);
			System.out.println(savedBoard);
		}
	}
	
	//@Test
	//@DisplayName("게시판 새글 조회 테스트")
	/*
	public void findByWriterTest() {
		List<BoardDTO> boardList = boardRepository.findByWriter("부트");
		for(BoardDTO board : boardList) {
			System.out.println(board);
		}
	}
	*/
	public void findByWriterTest() {
		/*
		 * List<BoardDTO> boardList = boardRepository.findByWriter("정지연"); for(BoardDTO
		 * board : boardList) { System.out.println(board); }
		 */
	}
}
