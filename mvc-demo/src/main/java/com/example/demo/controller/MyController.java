package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;

@Controller
public class MyController {
	private List<Student> list = null;

	@RequestMapping
	public String showHome() {
		return "home";
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("student", new Student());
		return "showForm";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("STUDENT", student);
		return "student-confirmation";
	}

	@RequestMapping("/listStudent")
	public String listStudent(Model theModel) {
		list=new ArrayList<Student>();
		list.add(new Student("John", "Doe", "john@email.com"));
		list.add(new Student("Marry", "Public", "marry@email.com"));
		list.add(new Student("Sachin", "Tendulkar", "sachin@email.com"));
		list.add(new Student("Rahul", "Dravid", "rahul@email.com"));
		theModel.addAttribute("studentList", list);
		return "listStudent";
	}

}
