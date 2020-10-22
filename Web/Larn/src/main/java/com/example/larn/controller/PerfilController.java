package com.example.larn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.larn.model.Student;
import com.example.larn.model.Teacher;
import com.example.larn.model.User;
import com.example.larn.service.UserService;

@Controller
public class PerfilController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/student/profile", method = RequestMethod.GET)
	private ModelAndView showStudentUpdateForm(HttpServletRequest request) {
		Student user = (Student)request.getSession().getAttribute("user");
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("both/perfil");
		return mv;
	}
	
	@RequestMapping(value = "/student/profile", method = RequestMethod.POST)
	private ModelAndView studentUpdate(@Valid Student user, BindingResult bindingResult, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		userService.updateStudent(user);
		mv.addObject("successMessage", "Usuario alterado com sucesso!");
		mv.addObject("user", user);
		mv.setViewName("both/perfil");
		
		session.setAttribute("user", userService.findStudentByID(user.getId()));
		
		return mv;
	}
	
	@RequestMapping(value = "/teacher/profile", method = RequestMethod.GET)
	private ModelAndView profileTeacher(HttpServletRequest request) {
		Teacher user = (Teacher)request.getSession().getAttribute("user");
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("both/perfil");
		return mv;
	}
	
	@RequestMapping(value = "/teacher/profile", method = RequestMethod.POST)
	private ModelAndView studentUpdate(@Valid Teacher user, BindingResult bindingResult, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		userService.updateTeacher(user);
		mv.addObject("successMessage", "Usuario alterado com sucesso!");
		mv.addObject("user", user);
		mv.setViewName("both/perfil");
		
		session.setAttribute("user", userService.findTeacherByID(user.getId()));
		
		return mv;
	}
	
	public void setSessionUserAttributes(User user, HttpSession session) {
		
    	session.setAttribute("user", user);
    }
}
