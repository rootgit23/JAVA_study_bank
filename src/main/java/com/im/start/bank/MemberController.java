package com.im.start.bank;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/*")
// 이 클래스는 Controller역할, requestmapping에 들어가는 value값 url은 무조권 절대경로 이여야함
//Container에게 이 클래스의 객체를 생성 위임
public class MemberController {
	
	// annotation
	// @ : 설명+실행
	
	// /member/Login
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인 실행");
		return "/member/login";
	}
	
	//Get
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("조인 Get 실행");
		return "/member/join";
	}
	
	//Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(String ID,String pw,String name, String email, String phone) throws Exception {
		BankBookMembersDAO bankBookMembersDAO = new BankBookMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUser_name(ID);
		bankMembersDTO.setPassword(pw);
		bankMembersDTO.setName(name);
		bankMembersDTO.setEmail(email);
		bankMembersDTO.setPhone(phone);
		int result = bankBookMembersDAO.setJoin(bankMembersDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
		System.out.println("조인 Post 실행");
		return "/member/join";
	}

}
