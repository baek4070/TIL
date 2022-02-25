package net.koreate.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.dao.MemberDao;
import net.koreate.vo.MemberVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations= {"classpath:/context/root-context.xml"}
)
public class DBTest {
	

	@Test
	public void test1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 연결 실패");
		}
	}
	@Inject
	DataSource ds;
	
	@Test
	public void test2() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			System.out.println("database연결성공 Connection :"+conn);
		} catch (SQLException e) {
			System.out.println("ds 연결 실패");
		}
	}
	
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void test3() {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("연결 정보 객체 생성 완료 : " + session);
		System.out.println("conn : " + session.getConnection());
	}
	
	
	@Inject
	MemberDao dao;
	
	@Test
	public void test6() throws Exception{
		MemberVo vo = new MemberVo();
		vo.setUserid("user01");
		vo.setUserpw("user01");
		vo.setUsername("USER01");
		
		dao.insertMember(vo);
		
		System.out.println("입력 완료 : "+vo);
	}
}













