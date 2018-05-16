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

	// 가계부등록
	public void insertHouseHold(HouseHolds vo);

	// 가계부삭제
	public void deleteHouseHold(String household_seq);

	// 가계부수정
	public void fixHouseHold(HouseHolds vo);

	// 가계부리스트반환
	public ArrayList<HouseHolds> getHouseHoldList(String member_seq);

	// 로그인
	public Members loginID(Members vo);

	// 회원정보수정
	public void updateMemInfo(Members vo);

	//어카운트 생성(로그인시 널값으로 생성)
	public void insertAccount(String member_seq);

	//어카운트 정보 수정(메뉴바 설정 입력시 수정)
	public void updateAccount(Account a_vo);

	//가계부 사용 충 가격 구하기
	public int sumPrice(String member_seq);
	
	//현재총액 가져오기
	public int nowtotalMoney(String member_seq);
	
	//최근 1개월 이내 내역 검색
	public ArrayList<HouseHolds> searchForAMonth(String member_seq);

	// 최근 3개월 이내 내역 검색
	public ArrayList<HouseHolds> searchForThreeMonth(String member_seq);

	// 최근 6개월 이내 내역 검색
	public ArrayList<HouseHolds> searchForSixMonth(String member_seq);

	// 최근 12개월 이내 내역 검색
	public ArrayList<HouseHolds> searchForAnYear(String member_seq);
	
	//특정기간검색
	public ArrayList<HouseHolds> speciPeriod(HouseHolds vo);

	// 캘린더 메모 추가
	public void insertMemo(Schedule vo);

	// 캘린더 스케줄 추가
	public void insertSchedule(Schedule vo);
	public String returnInsertSchedule(Schedule vo);
	
	// 캘린더 일정 추가
	public void insertDD(Schedule vo);
	
	// 스케쥴 데이터 받아오기
	public ArrayList<Schedule> getSchedule(Members vo);

	// 스케쥴 삭제
	public void deleteSchedule(Schedule vo);

	// 하루 스케쥴 리프레시
	public ArrayList<Schedule> getDaySchedule(Schedule vo);

	
	
}
