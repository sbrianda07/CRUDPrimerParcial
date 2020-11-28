package com.uabc.edu.primerparcial.controller;

import com.uabc.edu.primerparcial.entity.Profesores;
import com.uabc.edu.primerparcial.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/usuarios")
public class ProfesorController {
    @Autowired
    ProfesorServiceImpl service;

    @GetMapping(value = "/agregar")
    public String guardarProfesor(Model model) {
        model.addAttribute("profesor", new Profesores());
        return "/usuarios/guardarProfesor";
        //Retorna a la página html
    }

    @PostMapping(value = "/agregar")
    public String guardarProfesor(@ModelAttribute Profesores prof, RedirectAttributes redirectAttrs) {

        service.guardarProfesor(prof);
        redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");

        return "redirect:/usuarios/mostrarProfesor";
    }

    @GetMapping(value = "/mostrarProfesor")
    public String mostrarProfesor(Model model) {
        model.addAttribute("profesores", service.obtenerProfesor());
        return "usuarios/mostrarProfesor";
    }
    @GetMapping(value = "/eliminar/{id}")
    public String eliminarProfesor(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("profesor", service.obtenerProfesor());

        boolean test = service.eliminarProfesor(id);
        return "redirect:/usuarios/mostrarProfesor";
    }

    @GetMapping(value = "/error")
    public String errorPage() {

        return "profesor/error";
    }

    @GetMapping(value = "/modificar/{id}")
    public String editarProfesor(@PathVariable("id") Integer id, Model model) {
        service.buscarProfesor(id);
        model.addAttribute("profesor", service.buscarProfesor(id));

        return "usuarios/modificarProfesor";
    }

    @PostMapping(value = "/modificar/{id}")
    public String actualizarProfesor(@ModelAttribute Profesores prof, RedirectAttributes redirectAttrs, @PathVariable("id") Integer id) {
        service.guardarProfesor(prof);
        redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");

        return "redirect:/usuarios/mostrarProfesor";

    }

}
