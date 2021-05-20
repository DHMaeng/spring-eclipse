package mc.sn.rest.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import mc.sn.rest.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public int addMember(MemberVO memberVO) throws DataAccessException;
	 public int updateMember(MemberVO memberVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public MemberVO searchMember(String id) throws DataAccessException;
}
