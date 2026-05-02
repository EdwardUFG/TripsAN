package com.trips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trips.models.Trip;
import com.trips.services.ITripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/trips")
public class TripController {
	
	@Autowired
	private ITripService tripServices;
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
        
		Trip trip = tripServices.buscarPorId(idTrip);
		System.out.println("Trip encontrado: " + trip);
		
		model.addAttribute("trip", trip);
		
		return "detalle";
	}

}
