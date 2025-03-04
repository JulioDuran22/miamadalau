package com.julio.proyectoromantico.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GaleriaController {

    private static final String IMAGE_DIRECTORY = "src/main/resources/static/images/";

    @GetMapping("/galeria")
    public String mostrarGaleria(Model model) {
        List<String> imagenes = listarImagenes();
        model.addAttribute("imagenes", imagenes);
        return "galeria"; // Nombre de la vista en templates/
    }

    private List<String> listarImagenes() {
        List<String> imagenes = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(IMAGE_DIRECTORY))) {
            for (Path path : directoryStream) {
                if (!Files.isDirectory(path)) {
                    imagenes.add("/images/" + path.getFileName().toString()); // Ruta accesible desde el navegador
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagenes;
    }

    @PostMapping("/seleccionar")
    public String seleccionarFoto(@RequestParam("fotoSeleccionada") String fotoSeleccionada, Model model) {
        model.addAttribute("fotoSeleccionada", fotoSeleccionada);
        return "rompecabezas"; // Redirige a la vista del rompecabezas con la imagen seleccionada
    }
}

