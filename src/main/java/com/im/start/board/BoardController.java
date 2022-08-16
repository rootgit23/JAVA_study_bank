package com.im.start.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.im.start.bank.BankMembersDTO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@RequestMapping(value = "list.file", method = RequestMethod.GET)
	public void list(Model model) throws Exception{
		System.out.println("list GET 실행");
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> ar = boardDAO.getList();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping(value = "detail.file", method = RequestMethod.GET)
	public String detail(Model model,BoardDTO boardDTO) throws Exception{
		System.out.println("detail GET 실행");
		BoardDAO boardDAO = new BoardDAO();
		boardDTO =  boardDAO.getDetail(boardDTO);
		model.addAttribute("detail", boardDTO);
		return "/board/detail";
	}
	
	@RequestMapping(value = "add.file", method = RequestMethod.GET)
	public String add(HttpSession session) throws Exception{
		System.out.println("add GET 실행");
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setUserName(bankMembersDTO.getUser_name());
		return "/board/add";
	}
	
	@RequestMapping(value = "add.file", method = RequestMethod.POST)
	public String add(BoardDTO boardDTO , HttpSession session) throws Exception{
		System.out.println("add POST 실행");
		BoardDAO boardDAO = new BoardDAO();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		boardDTO.setTitle(boardDTO.getTitle());
		boardDTO.setContent(boardDTO.getContent());
		boardDTO.setUserName(bankMembersDTO.getUser_name());
		int result = boardDAO.setAdd(boardDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else
			System.out.println("실패");
		return "redirect:./list.file";
	}
	
	@RequestMapping(value = "update.file", method = RequestMethod.GET)
	public void update(BoardDTO boardDTO, Model model) throws Exception{
		System.out.println("update GET 실행");
		BoardDAO boardDAO = new BoardDAO();
		boardDTO =  boardDAO.getDetail(boardDTO);
		model.addAttribute("detail", boardDTO);
	}
	
	@RequestMapping(value = "update.file", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO) throws Exception{
		System.out.println("update POST 실행");
		BoardDAO boardDAO = new BoardDAO();
		boardDTO.setTitle(boardDTO.getTitle());
		boardDTO.setContent(boardDTO.getContent());
		boardDTO.setNum(boardDTO.getNum());
		int result = boardDAO.setUpdate(boardDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else
			System.out.println("실패");
		return "redirect:./list.file";
	}
	
	@RequestMapping(value = "delete.file", method = RequestMethod.GET)
	public String delete(BoardDTO boardDTO) throws Exception{
		System.out.println("delete GET 실행");
		BoardDAO boardDAO = new BoardDAO();
		boardDTO.setNum(boardDTO.getNum());
		int result = boardDAO.setDelete(boardDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else
			System.out.println("실패");
		return "redirect:./list.file";
	}

}
