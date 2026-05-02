package com.trips.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trips.models.Rol;

@Service
public class RolServiceImpl implements IRolService {

	List<Rol> lista = null;
    
	public RolServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
		lista = new LinkedList<>();

		try {
			Rol r1 = new Rol();
			r1.setId(1);
			r1.setNomRol("vendedor");
			r1.setDescripcion("Encargado de realizar ventas y gestionar clientes.");
			r1.setActivo(true);
			r1.setFechaCreacion(sdf.parse("2026-01-10"));

			Rol r2 = new Rol();
			r2.setId(2);
			r2.setNomRol("cliente");
			r2.setDescripcion("Usuario con acceso limitado para ver información pública.");
			r2.setActivo(true);
			r2.setFechaCreacion(sdf.parse("2026-02-15"));

			Rol r3 = new Rol();
			r3.setId(3);
			r3.setNomRol("administrador");
			r3.setDescripcion("Usuario con permisos completos sobre la aplicación.");
			r3.setActivo(false);
			r3.setFechaCreacion(sdf.parse("2026-12-01"));
			
			Rol r4 = new Rol();
			r4.setId(4);
			r4.setNomRol("Gerente");
			r4.setDescripcion("Responsable de supervisar las operaciones y tomar decisiones estratégicas.");
			r4.setActivo(true);
			r4.setFechaCreacion(sdf.parse("2026-03-20"));

			lista.add(r1);
			lista.add(r2);
			lista.add(r3);
			lista.add(r4);
			
		} catch (ParseException e) {
			System.out.println("Error al intentar recuperar los roles" + e.getMessage());
		}
	}

	@Override
	public List<Rol> buscarTodos() {
		return lista;
	}

	@Override
	public Rol buscarPorId(Integer id) {
		if (id == null) {
			return null;
		}
		for (Rol r : lista) {
			if (id.equals(r.getId())) {
				return r;
			}
		}
		return null;
	}
}
