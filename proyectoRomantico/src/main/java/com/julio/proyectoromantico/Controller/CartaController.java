package com.julio.proyectoromantico.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CartaController {

    // Mapa con los mensajes según la imagen armada
    private static final Map<String, String> MENSAJES = Map.of(
            "imagen1.jpg", "Mi más querida y admirada Lau,<br><br>" +
                    "No hay un solo día en el que mi corazón no se rinda ante la luz que irradias. En cada gesto tuyo, en cada palabra, descubro una grandeza que trasciende lo ordinario. Eres, sin lugar a dudas, una mujer extraordinaria, cuyo espíritu ilumina incluso los momentos más grises. Permíteme ser testigo de tu grandeza, de tu valentía, de todo lo que eres y de todo lo que serás.<br><br>" +
                    "Con toda mi devoción,<br>" +
                    "Julio Duran",

            "imagen2.jpg", "Mi inspiración infinita,<br><br>" +
                    "Si pudiera escribir el destino con mis propias manos, lo llenaría de sueños inmensos para ti. No hay estrella en el firmamento que brille con más intensidad que la pasión con la que persigues tus anhelos. Tu determinación y tu espíritu indomable son prueba de que estás destinada a cosas grandiosas.<br><br>" +
                    "Nunca dejes de soñar, pues el mundo necesita más almas como la tuya: valientes, soñadoras y capaces de convertir lo imposible en realidad.<br><br>" +
                    "Eternamente tuyo,<br>" +
                    "Julio Duran",

            "imagen3.jpg", "Mi más preciado tesoro,<br><br>" +
                    "La vida, con todos sus misterios y caminos inesperados, se torna más hermosa cuando la contemplo a tu lado. Cada día, cada instante contigo es un recordatorio de que la verdadera aventura no se encuentra en tierras lejanas, sino en la risa compartida, en las miradas cómplices y en los latidos que se aceleran cuando estamos juntos.<br><br>" +
                    "Que cada día sea un viaje que emprendamos de la mano, disfrutando del amor que nos une.<br><br>" +
                    "Con el más profundo amor,<br>" +
                    "Julio Duran"
    );



    @GetMapping("/carta")
    public String mostrarCarta(@RequestParam(name = "imagen", required = false) String imagen, Model model) {
        // Obtener el mensaje correspondiente a la imagen
        String mensaje = MENSAJES.getOrDefault(imagen, "¡Bien hecho! 🎉");

        // Pasar el mensaje a la vista
        model.addAttribute("mensaje", mensaje);

        return "carta";
    }
}