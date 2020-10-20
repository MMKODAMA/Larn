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
import com.example.larn.model.Teacher;
import com.example.larn.model.User;
import com.example.larn.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	//Metodos para professores
	
	@RequestMapping(value = "/register/teacher", method = RequestMethod.GET)
	public ModelAndView registerTeacherPage() {
		ModelAndView mv = new ModelAndView();
		User user = new Teacher();
		mv.addObject("user", user);
		mv.setViewName("register/cadastro_professor");
		return mv;
	}
	
	@RequestMapping(value = "/register/teacher", method = RequestMethod.POST)
	public ModelAndView registerTeacher(@Valid Teacher user, BindingResult bindingResult, ModelMap map) {
		ModelAndView mv = new ModelAndView();

		if(bindingResult.hasErrors()) {
			mv.addObject("successMessage", "Favor corrigir os campos");
			map.addAttribute("bindingResult", bindingResult);
		} else if(userService.isUserAlredyPresent(user)) {
			mv.addObject("successMessage", "Usuario ja registrado");
		} else {
			userService.saveTeacher(user);
			mv.addObject("successMessage", "Usuario registrado com sucesso");
		}
		
		mv.addObject("user", user);
		mv.setViewName("register/cadastro_professor");
		
		return mv;
	}
	
	// Metodo para alunos
	
	@RequestMapping(value = "/register/student", method = RequestMethod.GET)
	public ModelAndView registerStudentPage() {
		ModelAndView mv = new ModelAndView();
		User user = new Student();
		mv.addObject("user", user);
		mv.setViewName("register/cadastro_aluno");
		return mv;
	}
	
	@RequestMapping(value = "/register/student", method = RequestMethod.POST)
	public ModelAndView registerStudent(@Valid Student user, BindingResult bindingResult, ModelMap map) {
		ModelAndView mv = new ModelAndView();

		if(bindingResult.hasErrors()) {
			mv.addObject("successMessage", "Favor corrigir os campos");
			map.addAttribute("bindingResult", bindingResult);
		} else if(userService.isUserAlredyPresent(user)) {
			mv.addObject("successMessage", "Usuario ja registrado");
		} else {
			userService.saveStudent(user);
			mv.addObject("successMessage", "Usuario registrado com sucesso");
		}
		
		mv.addObject("user", user);
		mv.setViewName("register/cadastro_aluno");
		
		return mv;
	}
}
