package com.im.start.bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.im.start.util.DBConnector;

@Repository
public class BankAccountDAO {
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BOOK_ACCOUNT VALUES(ACCOUNT_SEQ.NEXTVAL, ?, ?, SYSDATE)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankAccountDTO.getUserName());
		st.setLong(2, bankAccountDTO.getBookNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}

}
