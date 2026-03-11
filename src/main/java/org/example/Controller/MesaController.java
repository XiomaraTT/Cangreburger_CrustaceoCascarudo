package org.example.Controller;

import org.example.Estructuras.Arreglo.ArregloMesas;
import org.example.Estructuras.Arreglo.Mesa;
import org.example.Repository.MesaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mesas")
public class MesaController {

    private final MesaRepository mesaRepository;

    public MesaController(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @GetMapping
    public String verMesas(Model model) {
        // Obtener la instancia única del arreglo (Patrón Singleton)
        ArregloMesas arreglo = ArregloMesas.getInstancia();

        // Limpiar y recargar desde BD
        arreglo.limpiar();

        // Cargar mesas de la BD e insertarlas en el arreglo
        List<Mesa> mesasBD = mesaRepository.findAll();
        for (Mesa mesa : mesasBD) {
            arreglo.agregarMesa(mesa);
        }

        // Obtener las mesas del arreglo para mostrar en la vista
        List<Mesa> mesasArreglo = arreglo.obtenerMesas();
        model.addAttribute("mesas", mesasArreglo);
        model.addAttribute("totalMesas", arreglo.getContador());
        model.addAttribute("capacidadMaxima", arreglo.getCapacidad());
        model.addAttribute("mesasLibres", arreglo.contarLibres());
        model.addAttribute("mesasOcupadas", arreglo.contarOcupadas());

        return "mesas";
    }

    @PostMapping("/agregar")
    public String agregarMesa(@RequestParam int numero, @RequestParam int capacidad) {
        if (!mesaRepository.existsById(numero)) {
            Mesa mesa = new Mesa(numero, capacidad);
            mesaRepository.save(mesa);
        }
        return "redirect:/mesas";
    }

    @PostMapping("/ocupar")
    public String ocuparMesa(@RequestParam int numero) {
        mesaRepository.findById(numero).ifPresent(mesa -> {
            mesa.ocuparMesa();
            mesaRepository.save(mesa);
        });
        return "redirect:/mesas";
    }

    @PostMapping("/liberar")
    public String liberarMesa(@RequestParam int numero) {
        mesaRepository.findById(numero).ifPresent(mesa -> {
            mesa.liberarMesa();
            mesaRepository.save(mesa);
        });
        return "redirect:/mesas";
    }
}
