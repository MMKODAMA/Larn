package com.example.larn.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.larn.model.Aula;
import com.example.larn.model.Teacher;
import com.example.larn.repository.AulaRepository;
import com.example.larn.repository.TeacherRepository;
import com.example.larn.model.Categoria;
import com.example.larn.service.AulaService;
import com.example.larn.service.CategoriaService;

@Controller
public class TeacherController {

	@Autowired
	private AulaService aulaService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private AulaRepository aulaRepo;

	@Autowired
	private TeacherRepository teacherRepo;

	@RequestMapping(value = "/teacher/create_class", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("listCategorias", categoriaService.getAllCategoria());
		return "teacher/cadastrar_aula";

	}

	@RequestMapping(value = "/teacher/create_class", method = RequestMethod.POST)
	public String form(@Valid Aula aula, BindingResult bindingResult, RedirectAttributes attr) {

		if (bindingResult.hasErrors()) {
			attr.addFlashAttribute("mensagem", "Favor corrigir os campos...");
		} else {
			aulaService.saveAula(aula);
			attr.addFlashAttribute("mensagem", "Aula criada com sucesso!");
		}
		return "redirect:/teacher/create_class";
	}

	@RequestMapping(value = "/teacher/my_classes/{id}", method = RequestMethod.GET)
	public ModelAndView myClass(@PathVariable("id") Integer id, RedirectAttributes reditAttr) {

		ModelAndView mv = new ModelAndView();

		Optional<Teacher> optTeacher = teacherRepo.findById(id);
		// if (optTeacher.isPresent()) {}
		Teacher teacher = optTeacher.get();
		Iterable<Aula> aulas = aulaRepo.findByTeacher(teacher);

		mv.addObject("teacher", teacher);
		mv.addObject("aulas", aulas);
		mv.setViewName("both/meus_cursos");

		return mv;
	}

}