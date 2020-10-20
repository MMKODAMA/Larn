package com.example.larn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.larn.model.Student;
import com.example.larn.model.User;
import com.example.larn.service.UserService;

@Controller
public class AuthentificationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		User user = new Student();
		mv.addObject("user", user);
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid Student user, BindingResult bindingResult, ModelMap map) {
		ModelAndView mv = new ModelAndView();

		if(bindingResult.hasErrors()) {
			mv.addObject("successMessage", "Favor corrigir os campos");
			map.addAttribute("bindingResult", bindingResult);
		} else if(userService.isUserAlredyPresent(user)) {
			mv.addObject("successMessage", "Usuario ja registrado");
		} else {
			userService.saveUser(user);
			mv.addObject("successMessage", "Usuario registrado com sucesso");
		}
		
		mv.addObject("user", user);
		mv.setViewName("register");
		
		return mv;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/");
		return mv;
	}
	
}
