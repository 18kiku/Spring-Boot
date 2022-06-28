package com.springbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springbook.entity.BoardDTO;

public interface BoardRepository extends JpaRepository<BoardDTO, Long>{

	/*
	JPQL - Java Persistence Query Language
	-- JPA에서 제공하는 객체지향 쿼리 언어, 복잡한 쿼리문도 쉽게 작성할 수 있음, SQL과 매우 유사하다
	@Query 사용 
	*/
	//List<BoardDTO> findByWriter(String writer);
	
	
	
	@Query("select b from board b where b.writer like %% order by b.writer desc")
	List<BoardDTO> findByWriter(@Param("writer") String writer);
}
