package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mybatis.SqlSessionBean;

class MybatisSessionTest {
	private NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
	@Test
	void test() {
		fail("Not yet implemented");	
	}
	@DisplayName("SqlSession 연결 테스트")
	@Test
	void session() {
		SqlSession mapper = SqlSessionBean.getSession();
		assertNotEquals(mapper, null);
		mapper.close();
	}
	@DisplayName("select 전체 조회 테스트 - 현제 예상값 4")
	@Test
	void selectList() {
		assertEquals(dao.selectAll().size(), 4);
		
	}
	
//	@DisplayName("insert 테스트 - id:momo로 추가")
//	@Test
//	void insert() {
//		int result = dao.insert(NewMember.builder()
//				.id("momo")
//				.name("모모")
//				.password("1234")
//				.email("momo@naver.com")
//				.age(34)
//				.gender("2")
//				.hobbies("축구")
//				.build());
//		assertEquals(result, 1);
//	}
	
	@DisplayName("selectOne")
	@Test
	void selectOne() {
		NewMember vo = dao.selectOne("momo");
		assertEquals(vo.getName(), "모모");
	}
	@DisplayName("로그인테스트")
	@Test
	void login() {
		String id = "momo";
		String password = "1234";
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);
		
		NewMember vo = dao.login(map);
		assertNotNull(vo);
	}
}
