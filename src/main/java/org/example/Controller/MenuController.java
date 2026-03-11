package org.example.Controller;

import org.example.Estructuras.Arbol.ArbolMenu;
import org.example.Estructuras.Arbol.Plato;
import org.example.Repository.PlatoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final PlatoRepository platoRepository;

    public MenuController(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @GetMapping
    public String verMenu(Model model) {
        // Crear el árbol binario de búsqueda
        ArbolMenu arbol = new ArbolMenu();

        // Cargar todos los platos de la BD e insertarlos en el árbol
        List<Plato> platosBD = platoRepository.findAll();
        for (Plato plato : platosBD) {
            arbol.insertar(plato);
        }

        // Obtener los platos ordenados alfabéticamente (recorrido inorden)
        List<Plato> platosOrdenados = arbol.obtenerPlatos();

        model.addAttribute("platos", platosOrdenados);
        model.addAttribute("arbolTexto", arbol.mostrarInOrden());
        return "menu";
    }

    @PostMapping("/agregar")
    public String agregarPlato(@RequestParam String nombre, @RequestParam double precio, @RequestParam String categoria) {
        Plato plato = new Plato(nombre, precio, categoria);
        platoRepository.save(plato);
        return "redirect:/menu";
    }
}


