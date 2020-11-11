package com.example.larn.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.larn.model.Aula;
import com.example.larn.model.Student;
import com.example.larn.model.Teacher;
import com.example.larn.model.User;
import com.example.larn.repository.AulaRepository;
import com.example.larn.repository.StudentRepository;
import com.example.larn.service.AulaService;
import com.example.larn.service.CategoriaService;
import com.example.larn.service.UserService;

@Controller
public class StudentController {

	@Autowired
	private AulaService aulaService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private AulaRepository aulaRepo;

	@RequestMapping(value = "/student/search_class", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("listCategorias", categoriaService.getAllCategoria());
		return "/student/pesquisa_aula";
	}

	@RequestMapping(value = "/student/search_class", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam(value = "materia") String materia,
			@RequestParam(value = "dataInicio") Date dataInicio, @RequestParam(value = "dataFim") Date dataFim,
			Model model) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/pesquisa_aula");

		model.addAttribute("listCategorias", categoriaService.getAllCategoria());
		List<Aula> listaAulas = aulaRepo.findByMateriaAndDateBetween(materia, dataInicio, dataFim);
		mv.addObject("listaAulas", listaAulas);
		return mv;

	}

	@RequestMapping(value = "/student/home/{id}", method = RequestMethod.GET)
	public ModelAndView myClass(@PathVariable("id") Integer id, RedirectAttributes reditAttr) {
		
		ModelAndView mv = new ModelAndView();
		
		Optional<Student> optStudent = studentRepo.findById(id);
		//if (optTeacher.isPresent()) {}
		Student student = optStudent.get();
		Iterable<Aula> aulas = aulaRepo.findByStudent(student);
		
		mv.addObject("aulas", aulas);
		mv.setViewName("both/meus_cursos");
		
		return mv;
	}

	@RequestMapping(value = "/student/carrinho/{id}", method = RequestMethod.GET)
	public String comprar(@PathVariable("id") Integer id, Model model) {

		Optional<Aula> optAula = aulaRepo.findById(id);
		Aula aula = optAula.get();
		model.addAttribute("aula", aula);

		return "student/carrinho";
	}

	@RequestMapping(value = "/student/carrinho/{id}", method = RequestMethod.POST)
	public String comprarFinalizar(@RequestParam(value = "idAula") Integer idAula,
			@RequestParam(value = "email") String email, 
			RedirectAttributes attr) {

		Student t = studentRepo.findByEmail(email);
		Optional<Aula> optAula = aulaRepo.findById(idAula);
		Aula aula = optAula.get();
		attr.addFlashAttribute("mensagem", "Compra realizada com sucesso!");
		aulaService.saveCompra(aula, t);


		return "redirect:/student/carrinho/{id}";
	}

}
