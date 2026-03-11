package org.example.Controller;

import org.example.Estructuras.Arbol.Plato;
import org.example.Estructuras.Arreglo.Mesa;
import org.example.Estructuras.Cola.ColaPedidos;
import org.example.Estructuras.Cola.Pedido;
import org.example.Estructuras.Lista.Cliente;
import org.example.Repository.ClienteRepository;
import org.example.Repository.MesaRepository;
import org.example.Repository.PedidoRepository;
import org.example.Repository.PlatoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PlatoRepository platoRepository;
    private final MesaRepository mesaRepository;

    public PedidoController(PedidoRepository pedidoRepository,
                            ClienteRepository clienteRepository,
                            PlatoRepository platoRepository,
                            MesaRepository mesaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.platoRepository = platoRepository;
        this.mesaRepository = mesaRepository;
    }

    @GetMapping
    public String verPedidos(Model model) {
        // Obtener la instancia única de la cola (Patrón Singleton)
        ColaPedidos cola = ColaPedidos.getInstancia();

        // Limpiar y recargar desde BD
        cola.limpiar();

        // Cargar pedidos EN ESPERA de la BD y encolarlos (FIFO)
        List<Pedido> pedidosBD = pedidoRepository.findByEstadoOrderByIdAsc("EN ESPERA");
        for (Pedido pedido : pedidosBD) {
            cola.encolar(pedido);
        }

        // Obtener los pedidos de la cola para mostrar en la vista
        List<Pedido> pedidosEnCola = cola.obtenerPedidos();
        model.addAttribute("pedidos", pedidosEnCola);
        model.addAttribute("tamañoCola", cola.getSize());

        // Pedido en el frente de la cola (próximo a atender)
        model.addAttribute("pedidoFrente", cola.verFrente());

        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("platos", platoRepository.findAll());
        model.addAttribute("mesas", mesaRepository.findByOcupadaFalse());
        return "pedidos";
    }

    @PostMapping("/agregar")
    public String agregarPedido(@RequestParam Integer clienteId,
                                @RequestParam Integer platoId,
                                @RequestParam Integer mesaNumero,
                                @RequestParam int cantidad) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        Plato plato = platoRepository.findById(platoId).orElse(null);
        Mesa mesa = mesaRepository.findById(mesaNumero).orElse(null);

        if (cliente != null && plato != null && mesa != null) {
            // Crear pedido y guardarlo en la BD con estado EN ESPERA
            Pedido pedido = new Pedido(cliente, plato, mesa, cantidad, 0, "EN ESPERA");
            pedidoRepository.save(pedido);
        }

        return "redirect:/pedidos";
    }

    @PostMapping("/atender")
    public String atenderPedido() {
        // Obtener la instancia única de la cola (Patrón Singleton)
        ColaPedidos cola = ColaPedidos.getInstancia();

        // Limpiar y recargar desde BD
        cola.limpiar();
        List<Pedido> pedidosBD = pedidoRepository.findByEstadoOrderByIdAsc("EN ESPERA");
        for (Pedido pedido : pedidosBD) {
            cola.encolar(pedido);
        }

        // Desencolar el pedido del frente (FIFO)
        Pedido pedidoAtendido = cola.desencolar();

        if (pedidoAtendido != null) {
            // Actualizar estado en la BD
            pedidoAtendido.setEstado("ATENDIDO");
            pedidoRepository.save(pedidoAtendido);
        }

        return "redirect:/pedidos";
    }
}
