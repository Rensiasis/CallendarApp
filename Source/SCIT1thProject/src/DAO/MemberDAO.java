package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import DAO.MybatisConfig;
import VO.HouseHolds;
import VO.Account;
import VO.Address;
import VO.Members;
import VO.Schedule;

public class MemberDAO {

	// 마이바티스 객체
	private static SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// 회원등록
	public static void insertMember(Members m_vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.insertMember(m_vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 회원아이디 중복체크
	public static int chkRepeatID(String id) {
		SqlSession session = null;
		int i = 0;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			i = mapper.chkRepeatID(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return i;
	}

	// 회원아이디 중복체크
	public static void deleteID(String member_seq) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.deleteID(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 가계부 삽입
	public static void insertHouseHold(HouseHolds vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.insertHouseHold(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 가계부 삭제
	public static void deleteHouseHold(String household_seq) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.deleteHouseHold(household_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 가계부 수정
	public static void fixHouseHold(HouseHolds vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.fixHouseHold(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 가계부 리스트불러오기
	public static ArrayList<HouseHolds> getHouseHoldList(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.getHouseHoldList(member_seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	// 아이디 비밀번호 일치 확인후 로그인 하기
	public static Members loginID(Members vo) {
		SqlSession session = null;
		Members result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.loginID(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	// 회원정보 수정
	public static void updateMemInfo(Members vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.updateMemInfo(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 어카운트 설정 입력
	public static void insertAccount(String member_seq) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.insertAccount(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 어카운트 수정
	public static void updateAccount(Account a_vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.updateAccount(a_vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static int beforeOpenAcc(String member_seq) {
		SqlSession session = null;
		int i = 0;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			i = mapper.beforeOpenAcc(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return i;
	}

	// 지출 구하기
	public static long sumPrice(String member_seq) {
		SqlSession session = null;
		long i = 0;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			i = mapper.sumPrice(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return i;
	}

	// 수입 구하기
	public static long sumPrice2(String member_seq) {
		SqlSession session = null;
		long i = 0;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			i = mapper.sumPrice2(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return i;
	}

	// 현재 총액 구하기
	public static long nowtotalMoney(String member_seq) {
		SqlSession session = null;
		long i = 0;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			i = mapper.nowtotalMoney(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return i;
	}

	// 가계부 1달 검색
	public static ArrayList<HouseHolds> searchForAMonth(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.searchForAMonth(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList<HouseHolds> searchForThreeMonth(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.searchForThreeMonth(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList<HouseHolds> searchForSixMonth(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.searchForSixMonth(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList<HouseHolds> searchForAnYear(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.searchForAnYear(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList<HouseHolds> speciPeriod(HouseHolds vo) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.speciPeriod(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	// 가계부 1달 검색
	public static ArrayList<HouseHolds> searchForAMonth2(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.searchForAMonth2(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList<HouseHolds> searchForThreeMonth2(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.searchForThreeMonth2(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList<HouseHolds> searchForSixMonth2(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.searchForSixMonth2(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList<HouseHolds> searchForAnYear2(String member_seq) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.searchForAnYear2(member_seq);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static ArrayList<HouseHolds> speciPeriod2(HouseHolds vo) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.speciPeriod2(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static void insertMemo(Schedule vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			mapper.insertMemo(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static String insertSchedule(Schedule vo) {
		SqlSession session = null;
		String result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			mapper.insertSchedule(vo);

			result = mapper.returnInsertSchedule(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static void insertDaySchedule(Schedule vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			mapper.insertDD(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static ArrayList<Schedule> getSchedule(Members vo) {
		SqlSession session = null;
		ArrayList<Schedule> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			result = mapper.getSchedule(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public static void deleteSchedule(Schedule vo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			mapper.deleteSchedule(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static ArrayList<Schedule> getDaySchedule(Schedule vo) {
		SqlSession session = null;
		ArrayList<Schedule> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			result = mapper.getDaySchedule(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

}
