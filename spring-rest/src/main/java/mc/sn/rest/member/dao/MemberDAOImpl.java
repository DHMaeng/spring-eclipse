package mc.sn.rest.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import mc.sn.rest.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberVO searchMember(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		MemberVO vo = (MemberVO) sqlSession.selectOne("mapper.member.selectMemberById", id);
		return vo;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("mapper.member.updateMember", memberVO);
		return result;
	}
}
