package com.example.sb.exercise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex")
public class BasicController {

	@GetMapping("/hello") 		//주소가 localhost:8090/sb/ex/hello 면 돌아감
	public String hello() {
		return "exercise/hello"; // 아까 만들었던 hello.html을 실행시킴
	}
}
