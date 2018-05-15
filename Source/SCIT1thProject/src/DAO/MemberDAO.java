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

	//가계부 삽입
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

	//가계부 삭제
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

	//가계부 수정
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

	//가계부 리스트불러오기
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

	// 가계부 설정 입력
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

	// 가계부 수정
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

	public static ArrayList<HouseHolds> searchForAMonth(HouseHolds vo) {

		SqlSession session = null;
		ArrayList<HouseHolds> hh = new ArrayList<HouseHolds>();
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			hh = mapper.searchForAMonth(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return hh;
	}

	public static ArrayList<HouseHolds> searchForThreeMonth(HouseHolds vo) {
		SqlSession session = null;
		ArrayList<HouseHolds> hh = new ArrayList<HouseHolds>();
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			hh = mapper.searchForThreeMonth(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return hh;
	}

	public static ArrayList<HouseHolds> searchForSixMonth(HouseHolds vo) {
		SqlSession session = null;
		ArrayList<HouseHolds> hh = new ArrayList<HouseHolds>();
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			hh = mapper.searchForSixMonth(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return hh;
	}

	public static ArrayList<HouseHolds> searchForAnYear(HouseHolds vo) {
		SqlSession session = null;
		ArrayList<HouseHolds> hh = new ArrayList<HouseHolds>();
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			hh = mapper.searchForAnYear(vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return hh;
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
