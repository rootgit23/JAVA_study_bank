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
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "DELETE BANK_BOOK WHERE BOOK_NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bankBookDTO.getBookNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}
	
	@Override
	public int setUpdate(BankBookDTO banBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BANK_BOOK SET BOOK_NAME = ? , BOOK_RATE = ? WHERE BOOK_NUM = ? ";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, banBookDTO.getBookName());
		st.setDouble(2, banBookDTO.getBookRate());
		st.setLong(3, banBookDTO.getBookNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}
	
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANK_BOOK ORDER BY BOOK_NUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOK_NUM"));
			bankBookDTO.setBookName(rs.getString("BOOK_NAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOK_RATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOK_SALE"));
			ar.add(bankBookDTO);
		}
		DBConnector.disConnection(rs, st, con);
		return ar;
	}
	
	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANK_BOOK WHERE BOOK_NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bankBookDTO.getBookNum());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getInt("BOOK_NUM"));
			bankBookDTO.setBookName(rs.getString("BOOK_NAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOK_RATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOK_SALE"));
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
		String sql = "INSERT INTO BANK_BOOK VALUES(?,?,?,?)";
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
		String sql = "UPDATE BANK_BOOK SET BOOK_SALE = 0 WHERE BOOK_NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bankBookDTO.getBookNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}

}
