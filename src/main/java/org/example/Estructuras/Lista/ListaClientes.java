package org.example.Estructuras.Lista;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase ListaClientes - Implementa el patrón Singleton
 * Garantiza una única instancia de la lista de clientes en toda la aplicación
 */
public class ListaClientes {

    // Instancia única (Singleton)
    private static ListaClientes instancia;

    private NodoCliente inicio;
    private int size;

    // Constructor privado (Singleton)
    private ListaClientes() {
        inicio = null;
        size = 0;
    }

    // Método para obtener la instancia única (Singleton)
    public static ListaClientes getInstancia() {
        if (instancia == null) {
            instancia = new ListaClientes();
        }
        return instancia;
    }

    // Limpiar la lista (para recargar desde BD)
    public void limpiar() {
        inicio = null;
        size = 0;
    }

    // Insertar al inicio de la lista enlazada
    public void insertar(Cliente cliente) {
        NodoCliente nuevo = new NodoCliente(cliente);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
        size++;
    }

    // Eliminar por codigo
    public void eliminar(String codigo) {
        NodoCliente actual = inicio;
        NodoCliente anterior = null;

        while (actual != null) {
            if (actual.getCliente().getCodigo().equals(codigo)) {
                if (anterior == null) {
                    inicio = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                size--;
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }

    // Buscar cliente por codigo
    public Cliente buscar(String codigo) {
        NodoCliente actual = inicio;
        while (actual != null) {
            if (actual.getCliente().getCodigo().equals(codigo)) {
                return actual.getCliente();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Verificar si la lista esta vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    // Obtener el tamanio de la lista
    public int getSize() {
        return size;
    }

    // Obtener todos los clientes como lista (para mostrar en la vista)
    public List<Cliente> obtenerClientes() {
        List<Cliente> lista = new ArrayList<>();
        NodoCliente actual = inicio;

        while (actual != null) {
            lista.add(actual.getCliente());
            actual = actual.getSiguiente();
        }

        return lista;
    }

    // Mostrar la lista como texto
    public String mostrar() {
        NodoCliente aux = inicio;
        StringBuilder texto = new StringBuilder("LISTA DE CLIENTES - CANGREBURGER\n\n");

        while (aux != null) {
            Cliente c = aux.getCliente();
            texto.append("Codigo: ").append(c.getCodigo())
                    .append(" | Nombre: ").append(c.getNombre())
                    .append(" ").append(c.getApellido())
                    .append("\n");

            aux = aux.getSiguiente();
        }

        return texto.toString();
    }
}
