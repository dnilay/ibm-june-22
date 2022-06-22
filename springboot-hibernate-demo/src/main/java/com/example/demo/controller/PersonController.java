package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@Controller
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping
	public String listPerson(Model model) {
		List<Person> list = personService.getAllPersons();
		model.addAttribute("persons", list);
		return "list_person";
	}
	@GetMapping("/showForm")
	public String showForm(Model theModel)
	{
		theModel.addAttribute("person",new Person());
		return "person-form";
	}

}
