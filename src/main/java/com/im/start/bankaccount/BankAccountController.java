package com.im.start.bankaccount;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.im.start.bank.BankMembersDTO;

@Controller
@RequestMapping("/bankAccount/*")

public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping(value = "add.file", method = RequestMethod.GET)
	public String add(long bookNum,HttpSession session) throws Exception{
		System.out.println("bankAccountAdd");
		System.out.println(bookNum);
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		BankAccountDTO bankAccountDTO = new BankAccountDTO();
		bankAccountDTO.setUserName(bankMembersDTO.getUser_name());
		bankAccountDTO.setBookNum(bookNum);
		int result = bankAccountService.add(bankAccountDTO);
		return "redirect:../bankbook/list.file";
	}
	
	

}
