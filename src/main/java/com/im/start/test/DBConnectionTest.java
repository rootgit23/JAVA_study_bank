package com.im.start.test;

import java.sql.Connection;

import com.im.start.bank.BankBookMembersDAO;
import com.im.start.bank.BankMembersDTO;
import com.im.start.util.DBConnector;

public class DBConnectionTest {

	public static void main(String[] args) {
		try {
			Connection con = DBConnector.getConnection();
			System.out.println(con != null);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
