package com.trips.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Date; 
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trips.models.Trip;
import com.trips.services.ITripService;

@Controller
public class HomeControllers {

	@Autowired
	private ITripService tripServices;
	
	
	@GetMapping({"/", "/home"})
	public String mostrarHome(Model model) {
		model.addAttribute("mensaje", "Hola mundo");
		model.addAttribute("trips", tripServices.buscarTodos());
		return "home";
	}

	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<>();
		lista.add("En la montaña");
		lista.add("En la ciudad ");
		lista.add("En los pueblos");
		lista.add("En las playas");
		model.addAttribute("listadoTrips", lista);
		return "listado";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Trip trip = new Trip();
		trip.setNombre("Rapel en Volcatenango"); 
		trip.setDescripcion("Aventura extrema en las montañas");
		trip.setFecha(new Date());
		trip.setCosto(25.50);
		
		model.addAttribute("trip", trip);
		return "detalle";
	}



	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		
		List<Trip> lista = tripServices.buscarTodos();
		
		for (Trip t : lista) {
			System.out.println("Trip: " + t.getNombre() + " - fecha=" + t.getFecha());
		}
		model.addAttribute("trips", lista);
		
		return "tabla";
		
	}
	
	
	

}
