package com.example.sb.exercise;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/tl")
public class ThymeleafController {

	@GetMapping("/tag")
	public String tag(Model model) {
		model.addAttribute("name", "제임스");
		model.addAttribute("data", "<b>HelloSpring</b>");
		return "thymeleaf/tag";
	}
	
	@GetMapping("/el")
	public String el(HttpSession session, Model model) {
		Member member = new Member(101, "제임스", 25);
		Member member2 = new Member(102, "마리아", 23);
		
		List<Member> list = new ArrayList<Member>();
		list.add(member);
		list.add(member2);
		
		model.addAttribute("member", member);
		model.addAttribute("memberList", list);
		
		session.setAttribute("sessUname", "제임스");
		session.setAttribute("sessAge", 25);
		model.addAttribute("now", LocalDateTime.now());
		return "thymeleaf/el";
	}
	
	@GetMapping("/url")
	public String url(Model model) {
		model.addAttribute("uid", "james");
		model.addAttribute("page", 1);
		model.addAttribute("data", "spring");		
		return "thymeleaf/url";
	}
	
	@GetMapping("/params")
	@ResponseBody
	public String params(String uid, int page) {
		return "<h1>uid=" + uid + ", page=" + page + "</h1>";
	}
	
	@GetMapping("/iter")
	public String iter(Model model) {
		List<Member> list = new ArrayList<>();
		list.add(new Member(101, "제임스", 25));
		list.add(new Member(102, "마리아", 23));
		list.add(new Member(103, "브라이언", 31));
		list.add(new Member(104, "엠마", 28));		
		
		model.addAttribute("memberList", list);
		return "thymeleaf/iter";
	}
	
	@GetMapping("/cond")
	public String cond(Model model) {
		List<Member> list = new ArrayList<>();
		list.add(new Member(101, "제임스", 25));
		list.add(new Member(102, "마리아", 23));
		list.add(new Member(103, "브라이언", 31));
		list.add(new Member(104, "엠마", 28));		
		
		model.addAttribute("memberList", list);
		model.addAttribute("num1", 3);
		model.addAttribute("num2", 4);
		return "thymeleaf/cond";
	}
}
