package com.example.larn.controller;

import javax.servlet.http.HttpServletRequest;
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
public class PerfilController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/student/profile", method = RequestMethod.GET)
	private ModelAndView showStudentUpdateForm(HttpServletRequest request) {
		Student user = (Student)request.getSession().getAttribute("user");
		System.out.println("ID: " + user.getId());
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("both/perfil");
		return mv;
	}
	
	@RequestMapping(value = "/student/profile", method = RequestMethod.POST)
	private ModelAndView studentUpdate(@Valid Student user, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		System.out.println(user.getId());
		userService.updateStudent(user);
		mv.addObject("successMessage", "Usuario registrado com sucesso");
		
		mv.addObject("user", user);
		
		mv.setViewName("both/perfil");
		return mv;
	}
	
	@RequestMapping(value = "/teacher/profile", method = RequestMethod.GET)
	private ModelAndView profileTeacher() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("both/perfil");
		return mv;
	}
}
