package com.example.larn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/teacher/home", method = RequestMethod.GET)
	public ModelAndView logTeacher() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("teacher/home_professor");
		return mv;
	}
	
	//TESTE DE SESSAO
	@RequestMapping(value = "/student/teste", method = RequestMethod.GET)
	public ModelAndView testet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/teste");
		return mv;
	}
	
	@RequestMapping(value = "/teacher/teste", method = RequestMethod.GET)
	public ModelAndView teste() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("teacher/teste");
		return mv;
	}
	
}
