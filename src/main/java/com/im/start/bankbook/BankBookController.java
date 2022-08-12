package com.im.start.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")

public class BankBookController {
	
	@RequestMapping(value = "list.file", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		//ModelAndView mv = new ModelAndView();
		System.out.println("list GET 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list",ar);
		return "/bankbook/list";
	}
	
	@RequestMapping(value = "detail.file", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail GET 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		//return "/bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
		return mv;
	}
	
	@RequestMapping(value = "add.file", method = RequestMethod.GET)
	public void add() {
		System.out.println("add get 실행");
		//return "/bankbook/add";
	}
	
	@RequestMapping(value = "add.file", method = RequestMethod.POST)
	public ModelAndView add(int bookNum, String bookName, double bookRate, int bookSale) throws Exception {
		System.out.println("add post 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNum(bookNum);
		bankBookDTO.setBookName(bookName);
		bankBookDTO.setBookRate(bookRate);
		bankBookDTO.setBookSale(bookSale);
		int result = bankBookDAO.setBankBook(bankBookDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else
			System.out.println("실패");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list.file");
		return mv;
	}
	
	@RequestMapping(value = "update.file", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO,Model model) throws Exception{
		System.out.println("update GET 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		model.addAttribute("detail", bankBookDTO);
		
	}
	
	@RequestMapping(value = "update.file", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception{
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO.setBookName(bankBookDTO.getBookName());
		bankBookDTO.setBookRate(bankBookDTO.getBookRate());
		bankBookDTO.setBookNum(bankBookDTO.getBookNum());
		int result = bankBookDAO.setUpdate(bankBookDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else
			System.out.println("실패");
		return "redirect:./detail.file?bookNum=" + bankBookDTO.getBookNum();
		
	}
	
	@RequestMapping(value = "delete.file", method = RequestMethod.GET)
	public String delete(BankBookDTO bankBookDTO) throws Exception{
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO.setBookNum(bankBookDTO.getBookNum());
		int result = bankBookDAO.setDelete(bankBookDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else
			System.out.println("실패");
		return "redirect:./list.file";
	}
	

}
