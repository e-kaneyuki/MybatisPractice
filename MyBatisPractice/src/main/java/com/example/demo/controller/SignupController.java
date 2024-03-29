package com.example.demo.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.GroupOrder;
import com.example.demo.form.SignupForm;
import com.example.demo.service.UserAppricationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
	@Autowired
	private UserAppricationService userApplicationService;
	
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, 
			@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return getSignup(model,locale,form);
		}
		log.info(form.toString());

		return "redirect:/login";
	}
}
