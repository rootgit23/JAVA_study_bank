package com.im.start.bank;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
// 이 클래스는 Controller역할, requestmapping에 들어가는 value값 url은 무조권 절대경로 이여야함
//Container에게 이 클래스의 객체를 생성 위임
public class MemberController {
	
	@Autowired
	private BankMembersService bankMembersService;
	
	// annotation
	// @ : 설명+실행
	
	// /member/Login
	@RequestMapping(value = "login.file", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		return "/member/login";
	}
	
	@RequestMapping(value = "login.file", method = RequestMethod.POST)
	public String login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("DB에 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		// "redirect:다시 접속할 URL(절대경로,상대경로)"
		return "redirect:../";
	}
	
	@RequestMapping(value = "logout.file" , method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	//Get
	@RequestMapping(value = "join.file", method = RequestMethod.GET)
	public String join() {
		System.out.println("조인 Get 실행");
		return "/member/join";
	}
	
	//Post
	@RequestMapping(value = "join.file", method = RequestMethod.POST)
	public String join(String USER_NAME,String PASSWORD,String NAME, String EMAIL, String PHONE) throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUser_name(USER_NAME);
		bankMembersDTO.setPassword(PASSWORD);
		bankMembersDTO.setName(NAME);
		bankMembersDTO.setEmail(EMAIL);
		bankMembersDTO.setPhone(PHONE);
		int result = bankMembersService.setJoin(bankMembersDTO);
		if(result == 1) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
		System.out.println("조인 Post 실행");
		
		//로그인폼 페이지로 이동
		//redirect
		return "redirect:./login.file";
	}
	
	@RequestMapping(value = "search.file", method = RequestMethod.GET)
	public void getSearchByID() throws Exception {
		System.out.println("search GET 실행");
	}
	
	@RequestMapping(value = "search.file", method = RequestMethod.POST)
	public String getSearchByID(String search,Model model) throws Exception {
		System.out.println("search Post 실행");
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
		model.addAttribute("list", ar);
		return "member/list";
	}

}
