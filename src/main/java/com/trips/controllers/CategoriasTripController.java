package com.trips.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trips.models.Categoria;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasTripController {

    private List<Categoria> lista = new ArrayList<>();

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        model.addAttribute("categorias", lista);
        return "categoriasTrip/listCategoria";
    }

    @GetMapping("/create")
    public String crearCategoria() {
        return "categoriasTrip/formCategoria";
    }

    @PostMapping("/save")
    public String guardarCategoria(@RequestParam("nomCategoria") String nomCategoria,
                                   @RequestParam("descripcion") String descripcion,
                                   @RequestParam(value="activo", defaultValue="false") boolean activo) {
        
        int nuevoId = lista.size() + 1;

        Categoria nueva = new Categoria(nuevoId, nomCategoria, descripcion, activo);
        lista.add(nueva);

       
        return "redirect:/categorias/index";
    }

    }
