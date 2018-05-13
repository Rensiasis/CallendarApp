package DAO;

import VO.Members;

public interface MemberMapper {
	// 회원등록
	public void insertMember(Members m_vo);

	// 중복아이디검사
	public int chkRepeatID(String id);
}
