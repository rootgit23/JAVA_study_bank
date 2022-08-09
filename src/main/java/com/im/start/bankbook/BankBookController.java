package com.im.start.bankbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")

public class BankBookController {
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		System.out.println("list GET 실행");
		return "/bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(long bookNum) {
		System.out.println("detail GET 실행");
		System.out.println("bookNum :" + bookNum);
		return "/bankbook/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("add get 실행");
		return "/bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(long booknum, String bookname, double bookrate, int booksale) throws Exception {
		System.out.println("add post 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(booknum);
		bankBookDTO.setBookName(bookname);
		bankBookDTO.setBookRate(bookrate);
		bankBookDTO.setBookSale(booksale);
		int result = bankBookDAO.setBankBook(bankBookDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else
			System.out.println("실패");
		return "/bankbook/add";
	}
	

}
