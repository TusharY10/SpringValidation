package com.validate.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.entities.Entities;

import jakarta.validation.Valid;
@Controller
public class FormController {
	@GetMapping("/form")
	public String openForm(Model model) {
		model.addAttribute("loginData",new Entities());
		return "form";
	}
	
	//handler for process
	@PostMapping("/process")
	//Keep binding result after model attribute always
	public String success(@Valid @ModelAttribute("loginData") Entities entities,BindingResult result ) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println(entities);
		return "success";
	}

}
