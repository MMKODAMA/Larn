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

	// Metodos para professores

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

		if (userService.isUserAlredyPresent(user)) {
			
			mv.addObject("warn", "Usuario já registrado");
			
		} else if (userService.isCpfAlredyPresent(user)) {
			
			mv.addObject("warn", "CPF já registrado");
			
		} else if (bindingResult.hasErrors()) {
			
			mv.addObject("failed", "Favor corrigir os campos");
			
			if (user.getPassword().length() < 6) {
				mv.addObject("senha", "A senha deve ter entre 6 a 10 caracteres");
			}
			
			map.addAttribute("bindingResult", bindingResult);
		} else {
			userService.saveTeacher(user);
			mv.addObject("successMessage", "Você se cadastrou com sucesso");
		}

		User user2 = new Teacher();
		mv.addObject("user", user2);
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
		
		if (userService.isUserAlredyPresent(user)) {
			
			mv.addObject("warn", "Usuario já registrado");
			
		} else if (userService.isCpfAlredyPresent(user)) {
			
			mv.addObject("warn", "CPF já registrado");
			
		} else if (bindingResult.hasErrors()) {
			
			mv.addObject("failed", "Favor corrigir os campos");
			
			if (user.getPassword().length() < 6) {
				mv.addObject("senha", "A senha deve ter entre 6 a 10 caracteres");
			}
			
			map.addAttribute("bindingResult", bindingResult);
		} else {
			userService.saveStudent(user);
			mv.addObject("successMessage", "Você se cadastrou com sucesso");
		}

		User user2 = new Teacher();
		mv.addObject("user", user2);
		mv.setViewName("register/cadastro_aluno");

		return mv;
	}
}
