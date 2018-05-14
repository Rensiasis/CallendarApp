package DAO;

import java.util.ArrayList;

import VO.HouseHolds;
import VO.Address;
import VO.Members;

public interface MemberMapper {
	// 회원등록
	public void insertMember(Members m_vo);

	// 중복아이디검사
	public int chkRepeatID(String id);
	
	//가계부등록
	public void insertHouseHold(HouseHolds vo);
	
	//가계부삭제
	public void deleteHouseHold(HouseHolds vo);
	
	//가계부수정
	public void fixHouseHold(HouseHolds vo);
	
	//가계부리스트반환
	public ArrayList<HouseHolds> getHouseHoldList(Members vo);
	
	//로그인
	public int loginID(Members vo);
	
	//로그인아이디정보 User.java에 저장하기
	public Members loginMember(Members vo);
}
