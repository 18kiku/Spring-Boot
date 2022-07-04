 package com.springbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbook.entity.MemberDTO;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Override
	public MemberDTO checkIdMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDTO getMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO loginMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * @Autowired private MemberDAOMybatis2 memberDAO;
	 * 
	 * @Autowired private BoardDAOMybatis2 boardDAO;
	 * 
	 * @Override public MemberDTO checkIdMember(MemberDTO dto) {
	 * System.out.println("==> MemberServiceImpl - checkIdMember()"); return
	 * memberDAO.checkIdMember(dto); }
	 * 
	 * @Override public void insertMember(MemberDTO dto) {
	 * System.out.println("==> MemberServiceImpl - insertMember()");
	 * memberDAO.insertMember(dto); }
	 * 
	 * @Override public void updateMember(MemberDTO dto) {
	 * System.out.println("==> MemberServiceImpl - updateMember()");
	 * memberDAO.updateMember(dto); }
	 * 
	 * @Override
	 * 
	 * @Transactional("txManager") public void deleteMember(MemberDTO dto) {
	 * System.out.println("==> MemberServiceImpl - deleteMember()"); BoardDTO board
	 * = new BoardDTO(); board.setWriter(dto.getId());
	 * boardDAO.deleteBoardById(board); memberDAO.deleteMember(dto); }
	 * 
	 * @Override public MemberDTO getMember(MemberDTO dto) {
	 * System.out.println("==> MemberServiceImpl - getMember()"); return
	 * memberDAO.getMember(dto); }
	 * 
	 * @Override public MemberDTO loginMember(MemberDTO dto) {
	 * System.out.println("==> MemberServiceImpl - loginMember()"); return
	 * memberDAO.loginMember(dto); }
	 */
	
}
