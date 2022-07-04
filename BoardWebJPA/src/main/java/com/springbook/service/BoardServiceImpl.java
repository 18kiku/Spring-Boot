package com.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springbook.entity.BoardDTO;
import com.springbook.repository.BoardRepository;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	
	
	  @Autowired private BoardRepository boardRepository;
	  
	  
		@Override
		public void insertBoard(BoardDTO dto) {
			System.out.println("==> BoardServiceImpl - InsertBoard()");
			//boardRepository.insertBoard(dto);
		}

		@Override
		public void updateBoard(BoardDTO dto) {
			System.out.println("==> BoardServiceImpl - updateBoard()");
			//boardRepository.updateBoard(dto);
		}

		@Override
		public void deleteBoard(BoardDTO dto) {
			System.out.println("==> BoardServiceImpl - deleteBoard()");
			//boardRepository.deleteBoard(dto);
		}

		@Override
		public List<BoardDTO> getBoardList(BoardDTO dto) {
			System.out.println("==> BoardServiceImpl - getBoardList()");
			return boardRepository.findAll(Sort.by("seq").descending());
		}

		@Override
		public void updateBoardCnt(BoardDTO dto) {
			System.out.println("==> BoardServiceImpl - updateBoardCnt()");
			//boardRepository.updateBoardCnt(dto);
		}

		@Override
		public BoardDTO getBoard(BoardDTO dto) {
			System.out.println("==> BoardServiceImpl - getBoard()");
			//updateBoardCnt(dto);
			//return boardRepository.getBoard(dto);
			return boardRepository.findById(dto.getSeq()).get();
		}

		@Override
		public int getBoardListCount(BoardDTO dto) {
			System.out.println("==> BoardServiceImpl - getBoardListCount()");
			//return boardRepository.getBoardListCount(dto);
			return 0;
		}
	 


}
