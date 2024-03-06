package com.example.sb.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ex")
public class BasicController {
	private final Logger log = LoggerFactory.getLogger(getClass()); // 로그 받기

	@GetMapping("/hello") 		//주소가 localhost:8090/sb/ex/hello 면 돌아감
	public String hello() {
		return "exercise/hello"; // templates에 만들었던 hello.html을 실행시킴
	}
	
	@ResponseBody 			// html 파일을 찾지 않고 데이터를 직접 전송
	@GetMapping("/noHtml")
	public String noHtml()
	{
		return "<h1>Hello Spring Boot!!!</h1>";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/ex/hello"; 	// /ex/hello 주소로 재연결
	}
	
	@GetMapping("/params")				// 파라메터 보내주는 방법
	public String params(Model model) { // Model 인수가 필요
		
		model.addAttribute("name", "james"); // name이라는 파라메터에 james라는 값 설정
		return "exercise/params"; // params.html 실행
	}
	
	@GetMapping("/params2")				
	public String params2(Model model, HttpServletRequest req) {
		
		String name = req.getParameter("name"); // 주소창의 파라메터 받기
		
		model.addAttribute("name", name); // 파라메터 전송
		return "exercise/params";
	}
	
	// Spring으로 간편하게 파라메터를 주기
	@GetMapping("/params3")				
	public String params3(Model model, String name, int count) { // 인수를 통해 파라메터 주기
		
		model.addAttribute("name", name + count); // 파라메터 전송
		return "exercise/params";
	}
	
	@GetMapping("/memberForm")
	public String memberForm() {
		
		return "exercise/memberForm";
	}

	@PostMapping("/memberProc") 	// POST를 받을 때 실행
	public String memberProc(Member member, Model model) {
		
		log.info(member.toString()); // 로그에 member를 기록함
		model.addAttribute("name", member.getName());
		
		return "exercise/params";
	}
}
