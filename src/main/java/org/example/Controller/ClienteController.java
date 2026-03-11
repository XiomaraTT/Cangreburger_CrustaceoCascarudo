package org.example.Controller;

import org.example.Estructuras.Lista.Cliente;
import org.example.Estructuras.Lista.ListaClientes;
import org.example.Repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public String verClientes(Model model) {
        // Obtener la instancia única de la lista (Patrón Singleton)
        ListaClientes lista = ListaClientes.getInstancia();

        // Limpiar y recargar desde BD
        lista.limpiar();

        // Cargar clientes de la BD e insertarlos en la lista enlazada
        List<Cliente> clientesBD = clienteRepository.findAll();
        for (Cliente cliente : clientesBD) {
            lista.insertar(cliente);
        }

        // Obtener los clientes de la lista enlazada para mostrar en la vista
        List<Cliente> clientesLista = lista.obtenerClientes();
        model.addAttribute("clientes", clientesLista);
        model.addAttribute("totalClientes", lista.getSize());

        return "clientes";
    }

    @PostMapping("/agregar")
    public String agregarCliente(
            @RequestParam String codigo,
            @RequestParam String nombre,
            @RequestParam String apellido
    ) {
        Cliente cliente = new Cliente(codigo, nombre, apellido);
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    @PostMapping("/eliminar")
    public String eliminarCliente(@RequestParam String codigo) {
        clienteRepository.findByCodigo(codigo)
                .ifPresent(clienteRepository::delete);
        return "redirect:/clientes";
    }
}
