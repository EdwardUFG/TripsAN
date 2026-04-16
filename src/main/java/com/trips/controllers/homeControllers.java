package com.trips.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Date; // <-- Nuevo importe para la fecha (Diapositiva 19)

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trips.models.Trip; // <-- Nuevo importe para usar tu modelo (Diapositiva 19)

@Controller
public class HomeControllers {

	@GetMapping("/")
	public String mostrarHome(Model model) {
		model.addAttribute("mensaje", "Hola mundo");
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

	// -------------------------------------------------------------
	// LO NUEVO DE LAS DIAPOSITIVAS
	// -------------------------------------------------------------

	// DIAPOSITIVA 19: Mostrar Detalle de un objeto
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Trip trip = new Trip();
		trip.setNombre("Rapel en Volcatenango"); // Usamos setNombre como lo dejamos en tu modelo
		trip.setDescripcion("Aventura extrema en las montañas"); // Usamos la palabra corregida
		trip.setFecha(new Date());
		trip.setCosto(25.50);
		
		model.addAttribute("trip", trip);
		return "detalle";
	}

	// DIAPOSITIVA 21 Y 24: Generar lista de objetos con propiedad destacado
	private List<Trip> getTrips() {
		List<Trip> lista = new LinkedList<>();
		
		Trip t1 = new Trip();
		t1.setId(1);
		t1.setNombre("Rapel");
		t1.setDescripcion("Aventura extrema");
		t1.setCosto(25.50);
		t1.setDestacado(1); // Requerimiento Diapositiva 24: 1 para SÍ destacado
		
		Trip t2 = new Trip();
		t2.setId(2);
		t2.setNombre("Caminata");
		t2.setDescripcion("Clima frio");
		t2.setCosto(15.00);
		t2.setDestacado(0); // Requerimiento Diapositiva 24: 0 para NO destacado
		
		lista.add(t1);
		lista.add(t2);
		return lista;
	}

	// DIAPOSITIVA 21: Enviar la lista a la vista de la tabla
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Trip> lista = getTrips();
		model.addAttribute("trips", lista);
		return "tabla";
	}

}
