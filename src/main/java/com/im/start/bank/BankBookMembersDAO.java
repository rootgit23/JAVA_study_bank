package com.im.start.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANK_MEMBERS VALUES(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankMembersDTO.getUser_name());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}
	
	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		search = "%" + search + "%";
		return (ArrayList)sqlSession.selectList(NAMESPACE+"getSearchByID",search);
	}

}
