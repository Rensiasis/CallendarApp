package DAO;

import org.apache.ibatis.session.SqlSessionFactory;

import DAO.MybatisConfig;

public class MemberDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	
}
