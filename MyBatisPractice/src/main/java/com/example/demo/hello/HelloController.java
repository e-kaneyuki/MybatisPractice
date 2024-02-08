package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService service;
	
	@GetMapping("/hello")
	public String getHello(Model model) {
		model.addAttribute("hello", "welcome");
		return "hello";
	}
	
	@PostMapping("/hello")
	public String postHello(@RequestParam("text1") String str, Model model) {
		model.addAttribute("str", str);
		return "hello/response";
	}
	
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2") String id, Model model) {
		Employee employee = service.getEmployee(id);
		model.addAttribute("employee", employee);
		return "hello/db";
	}
	
}
