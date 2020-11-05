package com.example.larn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.larn.model.Aula;
import com.example.larn.model.Student;
import com.example.larn.model.Teacher;
import com.example.larn.model.User;
import com.example.larn.service.AulaService;
import com.example.larn.service.UserService;

@Controller
public class TeacherController {
	
	@Autowired
	private AulaService aulaService;
	
	@RequestMapping(value = "/teacher/create_class", method = RequestMethod.GET)
	public ModelAndView createClass() {
		ModelAndView mv = new ModelAndView();
		Aula aula = new Aula();
		mv.addObject("aula", aula);
		mv.setViewName("teacher/cadastrar_aula");
		return mv;
	}
	
	@RequestMapping(value = "/teacher/create_class", method = RequestMethod.POST)
	public ModelAndView registerTeacher(@Valid Aula aula, BindingResult bindingResult, ModelMap map) {
		ModelAndView mv = new ModelAndView();

		if(bindingResult.hasErrors()) {
			mv.addObject("successMessage", "Favor corrigir os campos");
			map.addAttribute("bindingResult", bindingResult);
		}  else {
			aulaService.saveAula(aula);
			mv.addObject("successMessage", "Aula criada com sucesso!");
		}
		
		Aula aula1 = new Aula();
		mv.addObject("aula", aula1);
		mv.setViewName("/teacher/cadastrar_aula");
		
		return mv;
	}
	
	@RequestMapping(value = "/teacher/my_classes", method = RequestMethod.GET)
	public ModelAndView myClass() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("both/meus_cursos");
		return mv;
	}
	
}
