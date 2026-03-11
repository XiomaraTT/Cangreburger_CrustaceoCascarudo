package org.example.Controller;

import org.example.Estructuras.Cola.Pedido;
import org.example.Repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/historial")
public class HistorialController {

    private final PedidoRepository pedidoRepository;

    public HistorialController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public String verHistorial(Model model) {
        // Cargar todos los pedidos de la BD con sus relaciones
        List<Pedido> pedidosBD = pedidoRepository.findAllWithRelations();

        // Invertir la lista para simular una pila (el más reciente primero - LIFO)
        List<Pedido> pilaPedidos = new ArrayList<>(pedidosBD);
        Collections.reverse(pilaPedidos);

        model.addAttribute("pilaPedidos", pilaPedidos);
        return "historial";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable Integer id) {
        // Eliminar el pedido de la BD (simula pop de la pila)
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        }
        return "redirect:/historial";
    }
}
