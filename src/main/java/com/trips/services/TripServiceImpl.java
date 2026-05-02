package com.trips.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trips.models.Trip;

@Service
public class TripServiceImpl implements ITripService  {
	
	
	List<Trip> lista = null;
	
	public TripServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		lista = new LinkedList<>();
		
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
			t1.setImagen("rapel.jpg");

			Trip t2 = new Trip();
			t2.setId(2);
			t2.setNombre("Caminata");
			t2.setDescripcion("Clima frio");
			t2.setFecha(d2);
			t2.setCosto(15.00);
			t2.setDestacado(0);
			t2.setImagen("caminata.jpg");

			lista.add(t1);
			lista.add(t2);
		} catch (ParseException e) {
			System.out.println("Error al parsear la fecha: " + e.getMessage());
		}
	
	}
	
	@Override
	public List<Trip> buscarTodos() {
        
		return lista;
	}
	@Override
	public Trip buscarPorId(Integer idTrip) {
		for (Trip t : lista) 
			if (t.getId()==idTrip) 
				return t;
            
			return null;
    
	}
	

}
