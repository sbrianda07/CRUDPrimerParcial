package com.uabc.edu.primerparcial.controller;

import com.uabc.edu.primerparcial.entity.Intendentes;
import com.uabc.edu.primerparcial.service.impl.IntendenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/intendente")
public class IntendenteController {
    @Autowired
    IntendenteServiceImpl service;

    @GetMapping(value = "/agregar")
    public String agregarIntendente(Model model){
        model.addAttribute("intendente", new Intendentes());
        return "usuarios/guardarIntendente";
    }
    @PostMapping(value = "/agregar")
    public String guardarIntendente(@ModelAttribute Intendentes intend, RedirectAttributes redirectAttrs) {

        service.guardarIntendente(intend);
        redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");

        return "redirect:/intendente/mostrarIntendente";
    }
    @GetMapping(value = "/mostrarIntendente")
    public String mostrarIntendente(Model model) {
        model.addAttribute("intendentes", service.obtenerIntendente());
        return "usuarios/mostrarIntendente";
    }
    @GetMapping(value = "/eliminar/{id}")
    public String eliminarIntendente(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("intendente", service.obtenerIntendente());

        boolean test = service.eliminarIntendente(id);
        return "redirect:/intendente/mostrarIntendente";
    }

    @GetMapping(value = "/error")
    public String errorPage() {

        return "usuarios/error";
    }

    @GetMapping(value = "/modificar/{id}")
    public String editarIntendente(@PathVariable("id") Integer id, Model model) {
        service.buscarIntendente(id);
        model.addAttribute("intendente", service.buscarIntendente(id));

        return "usuarios/modificarIntendente";
    }

    @PostMapping(value = "/modificar/{id}")
    public String actualizarIntendente(@ModelAttribute Intendentes intend, RedirectAttributes redirectAttrs, @PathVariable("id") Integer id) {
        service.guardarIntendente(intend);
        redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");

        return "redirect:/intendente/mostrarIntendente";

    }
}
