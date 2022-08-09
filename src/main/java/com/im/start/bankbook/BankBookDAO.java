package com.im.start.bankbook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.im.start.util.DBConnector;

public class BankBookDAO implements BookDAO {
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			ar.add(bankBookDTO);
		}
		DBConnector.disConnection(rs, st, con);
		return ar;
	}
	
	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bankBookDTO.getBookNum());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
		}
		else
			return null;
		DBConnector.disConnection(rs, st, con);
		return bankBookDTO;
	}
	
	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		Calendar cal = Calendar.getInstance();
		long time = cal.getTimeInMillis();
		int num = (int)time;
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKBOOK VALUES(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1,bankBookDTO.getBookNum());
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		st.setInt(4, bankBookDTO.getBookSale());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}
	
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BANKBOOK SET BOOKSALE = 0 WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bankBookDTO.getBookNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}

}
