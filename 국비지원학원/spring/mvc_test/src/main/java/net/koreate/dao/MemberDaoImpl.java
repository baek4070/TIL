package net.koreate.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Inject
	SqlSession session;
	
	public String namespace="net.koreate.dao.MemberDao";
	
	@Override
	public void insertMember(MemberVo vo) throws Exception {
		session.insert(namespace+".insertMember",vo);
	}

}
