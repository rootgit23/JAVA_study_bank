package com.im.start.test;

import java.util.ArrayList;
import java.util.Calendar;

import com.im.start.bankbook.BankBookDAO;
import com.im.start.bankbook.BankBookDTO;

public class BankBookTest {

	public static void main(String[] args) {
		BankBookDTO bankBookDTO = new BankBookDTO();
		BankBookDAO bankBookDAO = new BankBookDAO();
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		int num = (int)time;
		try {
			//bankBookDTO.setBookNum(1);
			//int result = bankBookDAO.setChangeSale(bankBookDTO);
			//if(result > 0) {
			//	System.out.println("성공");
			//}
			//else
			//	System.out.println("실패");
			
			
			//bankBookDTO.setBookNum(num);
			//bankBookDTO.setBookName("농협");
			//bankBookDTO.setBookRate(4.14);
			//bankBookDTO.setBookSale(1);
		    //int result = bankBookDAO.setBankBook(bankBookDTO);
		    //if(result > 0) {
		    //	System.out.println("성공");
		    //}
		    //else
		    //	System.out.println("실패");
			
			
			//ArrayList<BankBookDTO> ar =  bankBookDAO.getList();
			//for(BankBookDTO bankBooksDTO : ar) {
			//	System.out.println(bankBooksDTO.getBookNum());
			//    System.out.println(bankBooksDTO.getBookName());
			//	System.out.println(bankBooksDTO.getBookRate());
			//	System.out.println(bankBooksDTO.getBookSale());
			//}
			
			
			bankBookDTO.setBookNum(1);
			bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
			if(bankBookDTO != null) {
				System.out.println(bankBookDTO.getBookNum());
				System.out.println(bankBookDTO.getBookName());
				System.out.println(bankBookDTO.getBookRate());
				System.out.println(bankBookDTO.getBookSale());
			}
			else
				System.out.println("찾는 번호가 없습니다");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
