package com.example.demo.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExController {
	
	@RequestMapping("/ex5") //커맨드 객체 없이 파라미터 바로 받기 localhost:8081/ex5?username=xxx&userage=20
	public String ex5(String username, 
					  @RequestParam(name="userage", required=false, defaultValue="10") Integer age) {
		System.out.println("username : " + username);
		System.out.println("age : " + age);
		return "index";
	}
	
	@RequestMapping("/ex4/{username}/{userage}")
	public String ex4(@PathVariable String username, @PathVariable(name = "userage") int age) {
		System.out.println("username : " + username);
		System.out.println("age : " + age);
		return "index";
	}
	
	@RequestMapping("/ex3")
	public String ex3(ListCodeVO vo) {
		System.out.println("ListCodeVO : " + vo);		
		return "index";
	}
	

	@RequestMapping("/ex2")
	public String ex2(EX1VO vo) {
		System.out.println("EX1VO : " + vo);		
		return "index";
	}
}
