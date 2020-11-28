package com.uabc.edu.primerparcial.controller;

import com.uabc.edu.primerparcial.entity.Alumnos;
import com.uabc.edu.primerparcial.entity.Intendentes;
import com.uabc.edu.primerparcial.service.impl.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/alumno")
public class AlumnoController {
    @Autowired
    AlumnoServiceImpl service;

    @GetMapping(value = "/agregar")
    public String agregarAlumno(Model model) {
        model.addAttribute("alumno", new Alumnos());
        return "usuarios/guardarAlumno";
    }
    @PostMapping(value = "/agregar")
    public String guardarAlumno(@ModelAttribute Alumnos al, RedirectAttributes redirectAttrs) {

        service.guardarAlumno(al);
        redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");

        return "redirect:/alumno/mostrarAlumno";
    }

    @GetMapping(value = "/mostrarAlumno")
    public String mostrarAlumno(Model model) {
        model.addAttribute("alumnos", service.obtenerAlumno());
        return "usuarios/mostrarAlumno";
    }
    @GetMapping(value = "/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alumno", service.obtenerAlumno());

        boolean test = service.eliminarAlumno(id);
        return "redirect:/alumno/mostrarAlumno";
    }

    @GetMapping(value = "/error")
    public String errorPage() {

        return "usuarios/error";
    }

    @GetMapping(value = "/modificar/{id}")
    public String editarAlumno(@PathVariable("id") Integer id, Model model) {
        service.buscarAlumno(id);
        model.addAttribute("alumno", service.buscarAlumno(id));

        return "usuarios/modificarAlumno";
    }

    @PostMapping(value = "/modificar/{id}")
    public String actualizarAlumno(@ModelAttribute Alumnos al, RedirectAttributes redirectAttrs, @PathVariable("id") Integer id) {
        service.guardarAlumno(al);
        redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");

        return "redirect:/alumno/mostrarAlumno";

    }
}
