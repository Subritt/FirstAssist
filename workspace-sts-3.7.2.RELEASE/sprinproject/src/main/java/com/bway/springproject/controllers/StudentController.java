package com.bway.springproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao sdao;
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String getStudentForm(Model model, HttpSession session){
		
		if(StringUtils.isEmpty(session.getAttribute("username"))){
			
			return "login";
			
		}
		
		model.addAttribute("stud", new Student());
		
		return "studentform";
		
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student s, Model model){

		sdao.addStudent(s);
		model.addAttribute("slist", sdao.getAllStudent());
		
		return "home";
		
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id, Model model){
		
		sdao.deleteStudent(id);
		model.addAttribute("slist", sdao.getAllStudent());
		
		return "home";
		
	}
	
	@RequestMapping(value="/{id}/edit", method = RequestMethod.GET)
	public String editStudent(@PathVariable("id") int id, Model model){
		
		model.addAttribute("stud", sdao.getById(id));
		
		return "editForm";
		
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute Student s, Model model){
		
		sdao.updateStudent(s);
		model.addAttribute("slist", sdao.getAllStudent());
		
		return "home";
		
	}

}
