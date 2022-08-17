package com.im.start.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.im.start.util.DBConnector;

@Repository
public class BankBookMembersDAO implements MembersDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.im.start.bank.BankBookMembersDAO.";
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getLogin",bankMembersDTO);
		
	}
	
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setJoin",bankMembersDTO);
	}
	
	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
			return sqlSession.selectList(NAMESPACE+"getSearchByID",search);
	}

}
