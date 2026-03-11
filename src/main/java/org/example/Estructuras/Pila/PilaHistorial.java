package org.example.Estructuras.Pila;

/**
 * Clase PilaHistorial - Implementa el patrón Singleton
 * Estructura de datos: Pila (LIFO - Last In, First Out)
 */
public class PilaHistorial {

    // Instancia única (Singleton)
    private static PilaHistorial instancia;

    private Nodo historialTope;

    private static class Nodo {
        HistorialAccion accion;
        Nodo siguiente;

        public Nodo(HistorialAccion accion) {
            this.accion = accion;
            this.siguiente = null;
        }
    }

    // Constructor privado (Singleton)
    private PilaHistorial() {
        historialTope = null;
    }

    // Método para obtener la instancia única (Singleton)
    public static PilaHistorial getInstancia() {
        if (instancia == null) {
            instancia = new PilaHistorial();
        }
        return instancia;
    }

    public void push(HistorialAccion accion) {
        Nodo nuevo = new Nodo(accion);
        nuevo.siguiente = historialTope;
        historialTope = nuevo;
    }

    public HistorialAccion pop() {
        if (historialTope == null) {
            return null; // pila vacía
        }
        HistorialAccion accion = historialTope.accion;
        historialTope = historialTope.siguiente;
        return accion;
    }

    public String mostrar() {
        StringBuilder texto = new StringBuilder("HISTORIAL DE ACCIONES\n\n");
        Nodo aux = historialTope;

        while (aux != null) {
            texto.append(aux.accion.getFechaHora())
                    .append(" - ")
                    .append(aux.accion.getDescripcion())
                    .append("\n");
            aux = aux.siguiente;
        }

        return texto.toString();
    }
}

