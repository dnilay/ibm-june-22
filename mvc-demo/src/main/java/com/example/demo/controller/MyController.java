package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;

@Controller
public class MyController {
	
	@RequestMapping
	public String showHome()
	{
		return "home";
	}
	@RequestMapping("/showForm")
	public String showForm(Model theModel)
	{
		theModel.addAttribute("student",new Student());
		return "showForm";
	}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student,Model model)
	{
		model.addAttribute("STUDENT", student);
		return "student-confirmation";
	}
	
	

}
