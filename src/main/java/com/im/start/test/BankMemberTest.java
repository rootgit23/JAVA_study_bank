package com.im.start.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.im.start.bank.BankBookMembersDAO;
import com.im.start.bank.BankMembersDTO;
import com.im.start.util.DBConnector;

public class BankMemberTest {

	public static void main(String[] args) {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		BankBookMembersDAO bankBookMembersDAO = new BankBookMembersDAO();
		List<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
		//bankMembersDTO.setUser_name("B");
		//bankMembersDTO.setPassword("b");
		//bankMembersDTO.setName("비");
		//bankMembersDTO.setEmail("b@naver.com");
		//bankMembersDTO.setPhone("010-2222-2222");
		try {
			ar = bankBookMembersDAO.getSearchByID("A");
			for(int i=0; i<ar.size(); i++) {
				bankMembersDTO = ar.get(i);
				System.out.println(bankMembersDTO.getUser_name());
				System.out.println(bankMembersDTO.getPassword());
				System.out.println(bankMembersDTO.getName());
				System.out.println(bankMembersDTO.getEmail());
				System.out.println(bankMembersDTO.getPhone());
			}
			
			//int result = bankBookMembersDAO.setJoin(bankMembersDTO);
			//if(result > 0) {
				//System.out.println("성공");
			//}
			//else {
				//System.out.println("실패");
			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
