package com.trips.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trips.models.Trip;
import com.trips.services.ITripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/save")
    public String guardar(Trip trip, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error: result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "trips/formTrip";
        }
        tripServices.guardar(trip);
        System.out.println("Trip: " + trip);
        return "trips/listTrips";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}