package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.PersonDao;
import com.example.demo.entity.Person;

@Controller
public class PersonController {

	private final PersonDao personDao;

	public PersonController(PersonDao personDao) {

		this.personDao = personDao;
	}

	@RequestMapping
	public String listPerson(Model model) {
		List<Person> list = personDao.findAll();
		model.addAttribute("persons", list);
		return "list_person";
	}

}
