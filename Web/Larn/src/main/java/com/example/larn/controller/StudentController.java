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
public class StudentController {
	
	@RequestMapping(value = "/student/search_class", method = RequestMethod.GET)
	public ModelAndView createClass() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/pesquisa_aula");
		return mv;
	}

}
