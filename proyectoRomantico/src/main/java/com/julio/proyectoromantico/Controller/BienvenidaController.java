package com.julio.proyectoromantico.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BienvenidaController {

    @GetMapping("/")
    public String mostrarBienvenida() {
        return "bienvenida";
    }
}

