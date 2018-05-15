package DAO;

import java.util.ArrayList;

import VO.HouseHolds;
import VO.Account;
import VO.Address;
import VO.Members;
import VO.Schedule;

public interface MemberMapper {
	// 회원등록
	public void insertMember(Members m_vo);

	// 중복아이디검사
	public int chkRepeatID(String id);

	//가계부등록
	public void insertHouseHold(HouseHolds vo);

	//가계부삭제
	public void deleteHouseHold(String household_seq);

	//가계부수정
	public void fixHouseHold(HouseHolds vo);

	//가계부리스트반환
	public ArrayList<HouseHolds> getHouseHoldList(String member_seq);

	//로그인
	public Members loginID(Members vo);

	//회원정보수정
	public void updateMemInfo(Members vo);

	//가계부 설정 등록
	public void insertAccount(String member_seq);

	//가계부
	public void updateAccount(Account a_vo);
	
	//최근 1개월 이내 내역 검색
	public ArrayList<HouseHolds> searchForAMonth(HouseHolds vo);

	//최근 3개월 이내 내역 검색
	public ArrayList<HouseHolds> searchForThreeMonth(HouseHolds vo);

	//최근 6개월 이내 내역 검색
	public ArrayList<HouseHolds> searchForSixMonth(HouseHolds vo);

	//최근 12개월 이내 내역 검색
	public ArrayList<HouseHolds> searchForAnYear(HouseHolds vo);
	
	//캘린더 메모 추가
	public void insertMemo(Schedule vo);
	
	//스케쥴 데이터 받아오기
	public ArrayList<Schedule> getSchedule(Members vo);
	
	//스케쥴 삭제
	public void deleteSchedule(Schedule vo);
	
	//하루 스케쥴 리프레시
	public ArrayList<Schedule> getDaySchedule(Schedule vo);
}
