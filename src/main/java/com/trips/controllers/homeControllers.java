package com.trips.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Date; // <-- Nuevo importe para la fecha (Diapositiva 19)
import java.text.SimpleDateFormat;
import java.text.ParseException;

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

	private List<Trip> getTrips() {
		List<Trip> lista = new LinkedList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = sdf.parse("2024-07-15");
			Date d2 = sdf.parse("2024-08-20");

			Trip t1 = new Trip();
			t1.setId(1);
			t1.setNombre("Rapel");
			t1.setDescripcion("Aventura extrema");
			t1.setFecha(d1);
			t1.setCosto(25.50);
			t1.setDestacado(1);

			Trip t2 = new Trip();
			t2.setId(2);
			t2.setNombre("Caminata");
			t2.setDescripcion("Clima frio");
			t2.setFecha(d2);
			t2.setCosto(15.00);
			t2.setDestacado(0);

			lista.add(t1);
			lista.add(t2);
		} catch (ParseException e) {
			System.out.println("Error al parsear la fecha: " + e.getMessage());
		}
		return lista;
	}

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Trip> lista = getTrips();
		model.addAttribute("trips", lista);
		return "tabla";
	}

}
