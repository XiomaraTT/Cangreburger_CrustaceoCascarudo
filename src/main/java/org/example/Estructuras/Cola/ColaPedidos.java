package org.example.Estructuras.Cola;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase ColaPedidos - Implementa el patrón Singleton
 * Garantiza una única instancia de la cola de pedidos en toda la aplicación
 */
public class ColaPedidos {

    // Instancia única (Singleton)
    private static ColaPedidos instancia;

    private NodoPedido frente;
    private NodoPedido fin;
    private int size;

    // Constructor privado (Singleton)
    private ColaPedidos() {
        frente = null;
        fin = null;
        size = 0;
    }

    // Método para obtener la instancia única (Singleton)
    public static ColaPedidos getInstancia() {
        if (instancia == null) {
            instancia = new ColaPedidos();
        }
        return instancia;
    }

    // Limpiar la cola (para recargar desde BD)
    public void limpiar() {
        frente = null;
        fin = null;
        size = 0;
    }

    // Encolar un pedido (FIFO - el primero en entrar es el primero en salir)
    public void encolar(Pedido pedido) {
        NodoPedido nuevo = new NodoPedido(pedido);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        size++;
    }

    // Desencolar - sacar el pedido del frente (FIFO)
    public Pedido desencolar() {
        if (frente == null) {
            return null;
        }

        Pedido pedido = frente.getPedido();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }
        size--;
        return pedido;
    }

    // Ver el pedido del frente sin sacarlo
    public Pedido verFrente() {
        if (frente == null) {
            return null;
        }
        return frente.getPedido();
    }

    // Verificar si la cola esta vacia
    public boolean estaVacia() {
        return frente == null;
    }

    // Obtener el size de la cola
    public int getSize() {
        return size;
    }

    // Obtener todos los pedidos como lista (para mostrar en la vista)
    public List<Pedido> obtenerPedidos() {
        List<Pedido> lista = new ArrayList<>();
        NodoPedido actual = frente;

        while (actual != null) {
            lista.add(actual.getPedido());
            actual = actual.getSiguiente();
        }

        return lista;
    }

    // Mostrar la cola como texto
    public String mostrar() {
        if (frente == null) {
            return "No hay pedidos en cola";
        }

        StringBuilder texto = new StringBuilder("Pedidos en espera:\n");
        NodoPedido r = frente;

        while (r != null) {
            texto.append(r.getPedido().toString()).append("\n");
            r = r.getSiguiente();
        }

        return texto.toString();
    }
}
