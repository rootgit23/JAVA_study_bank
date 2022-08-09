package com.im.start.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.im.start.util.DBConnector;

public class BankBookMembersDAO implements MembersDAO{
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKMEMBERS VALUES(?,?,?,?,?)";
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
		// TODO Auto-generated method stub
		BankMembersDTO bankMemberDTO = null;
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKMEMBERS WHERE ID LIKE ? ORDER BY ID ASC";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + search + "%");
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			bankMemberDTO = new BankMembersDTO();
			String id = rs.getString("ID");
			String pw = rs.getString("PW");
			String name = rs.getString("NAME");
			String email = rs.getString("EMAIL");
			String phone = rs.getString("PHONE");
			bankMemberDTO.setUser_name(id);
			bankMemberDTO.setPassword(pw);
			bankMemberDTO.setName(name);
			bankMemberDTO.setEmail(email);
			bankMemberDTO.setPhone(phone);
			ar.add(bankMemberDTO);
		}
		return ar;
	}

}
