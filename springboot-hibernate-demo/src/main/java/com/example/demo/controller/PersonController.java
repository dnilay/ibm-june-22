package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String showForm(Model theModel) {
		theModel.addAttribute("person", new Person());
		return "person-form";
	}

	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("person") Person thePerson)

	{
		personService.createPerson(thePerson);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int personId, Model theModel) {
		Person person = personService.getPersonById(personId).get();
		theModel.addAttribute("person", person);
		return "person-form";
	}

	@RequestMapping("/deletePerson")
	public String deletePerson(@RequestParam("personId") int personId) {
		personService.deletePerson(personId);
		return "redirect:/";

	}

	@GetMapping("/showSearchForm")
	public String showSearchForm() {
		return "search-form";
	}

	@PostMapping("/searchById")
	public String searchById(@RequestParam("personId") int personId, Model model) {
		Optional<Person> person = personService.getPersonById(personId);
		if (person.isEmpty()) {
			model.addAttribute("person", new Person());
		} else {
			model.addAttribute("person", person.get());
		}
		return "success";
	}
}
