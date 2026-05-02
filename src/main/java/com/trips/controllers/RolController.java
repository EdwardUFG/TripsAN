package com.trips.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trips.services.IRolService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/roles")
public class RolController {
    
	@Autowired
	private IRolService rolService;

	@GetMapping
	public String mostrarRoles(Model model) {
		model.addAttribute("roles", rolService.buscarTodos());

		return "categoriasTrip/roles";

	}
 
}
