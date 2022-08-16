package com.im.start.bank;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {
	
	@Autowired
	private BankBookMembersDAO bankBookMembersDAO;
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankBookMembersDAO.getLogin(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankBookMembersDAO.setJoin(bankMembersDTO);
	}
	
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankBookMembersDAO.getSearchByID(search);
	}
}
