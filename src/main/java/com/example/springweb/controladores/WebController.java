package com.example.springweb.controladores;

import com.example.springweb.modelos.Piloto;
import com.example.springweb.servicios.PilotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private PilotoServicio pilotoServicio;

    @RequestMapping(value ="/pilotos")
    public String findAll(Model model) {
        List<Piloto> pilotos = pilotoServicio.findAllPilotos();
        model.addAttribute("pilotos", pilotos);
        return "index";
    }

    @GetMapping(value = "/pilotos/nuevo")
    public String nuevoPiloto(Model model) {
        Piloto piloto = new Piloto();
        model.addAttribute("piloto", piloto);
        return "createPiloto";
    }

    @PostMapping(value = "/pilotos")
    public String guardarPiloto(@ModelAttribute("piloto") Piloto piloto) {
        pilotoServicio.createPiloto(piloto);
        return "redirect:/pilotos";
    }

    @GetMapping(value = "/pilotos/{id}")
    public String updatePiloto(@PathVariable String id, Model model) {
        Piloto piloto = pilotoServicio.findPiloto(id);
        model.addAttribute("piloto", piloto);
        return "updatePiloto";
    }

    @PostMapping(value = "/pilotos/{id}")
    public String actualizarPiloto(@PathVariable String id, @ModelAttribute("piloto") Piloto piloto) {
        Piloto exist = pilotoServicio.findPiloto(id);

        exist.setId(id);
        exist.setNombre(piloto.getNombre());
        exist.setAbreviatura(piloto.getAbreviatura());
        exist.setEquipo(piloto.getEquipo());
        exist.setNumero(piloto.getNumero());
        exist.setFechaNacimiento(piloto.getFechaNacimiento());
        exist.setPais(piloto.getPais());


        pilotoServicio.updatePiloto(piloto);
        return "redirect:/pilotos";
    }

    @RequestMapping(value ="/pilotos/delete/{id}")
    public String deleteUser(@PathVariable String id, Model model) {
        pilotoServicio.deletePiloto(id);
        return "redirect:/pilotos";
    }
}
