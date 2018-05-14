package DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import DAO.MybatisConfig;
import VO.HouseHolds;
import VO.Address;
import VO.Members;

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

	public static int chkRepeatID(String id) {// 회원아이디 중복체크
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

	public static void deleteHouseHold(HouseHolds vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.deleteHouseHold(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

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

	public static ArrayList<HouseHolds> getHouseHoldList(Members vo) {
		SqlSession session = null;
		ArrayList<HouseHolds> result = null;
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			result = mapper.getHouseHoldList(vo);
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

	// 로그인하고 회원 정보 USER에 입력하기.
	public static Members loginMember(Members vo) {
		SqlSession session = null;
		Members vo2 = new Members();

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			vo2 = mapper.loginMember(vo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return vo2;
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
}
