package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping
	public String home() {
		return "home";
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}

	@RequestMapping("/processForm")
	public String processForm(@RequestParam("t1") String str, Model theModel) {

		theModel.addAttribute("NAME", str);
		return "success";
	}

}
