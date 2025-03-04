package com.julio.proyectoromantico.Controller;

import com.julio.proyectoromantico.Entity.Foto;
import com.julio.proyectoromantico.Service.FotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RompecabezasController {

    private final FotoService fotoService;

    public RompecabezasController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping("/rompecabezas")
    public String mostrarRompecabezas(@RequestParam("fotoId") Long fotoId, Model model) {
        Optional<Foto> fotoSeleccionada = fotoService.obtenerPorId(fotoId);
        if (fotoSeleccionada.isPresent()) {
            model.addAttribute("fotoSeleccionada", fotoSeleccionada.get());
            return "rompecabezas"; // Carga la vista con el rompecabezas
        }
        return "redirect:/galeria"; // Si la foto no existe, regresa a la galería
    }
}
