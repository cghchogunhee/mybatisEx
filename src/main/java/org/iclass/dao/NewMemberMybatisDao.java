package org.iclass.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewMember;

import mybatis.SqlSessionBean;

public class NewMemberMybatisDao {
	private static final  NewMemberMybatisDao dao = new NewMemberMybatisDao();
	private NewMemberMybatisDao() {};
	public static NewMemberMybatisDao getInstance() {
		return dao;
	}
	
	//Exception 처리 필요 없음. 객체와 db컬럼 매핑 필요 없음. 리스트 add도 필요 없음
	public List<NewMember>selectAll(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<NewMember> list = mapper.selectList("selectAll");
		mapper.close(); //필수
		return list;
	}
	
	public int insert(NewMember vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("insert", vo);	//두번째 인자 vo는 insert에 필요한 파라미터
		mapper.commit();
		mapper.close();
		return result;
	}
	public NewMember selectOne(String id) { 
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember vo = mapper.selectOne("selectOne",id);
		mapper.close();
		return vo;
	}
	public NewMember login(Map<String, String> map) {
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember vo = mapper.selectOne("login",map);
		mapper.close();
		return vo;
	}
}
