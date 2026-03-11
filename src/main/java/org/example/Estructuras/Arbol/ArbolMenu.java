package org.example.Estructuras.Arbol;

/**
 * Clase ArbolMenu - Implementa el patrón Singleton
 * Estructura de datos: Árbol Binario de Búsqueda (BST)
 */
public class ArbolMenu {

    // Instancia única (Singleton)
    private static ArbolMenu instancia;

    private NodoPlato raiz;

    // Constructor privado (Singleton)
    private ArbolMenu() {
        raiz = null;
    }

    // Método para obtener la instancia única (Singleton)
    public static ArbolMenu getInstancia() {
        if (instancia == null) {
            instancia = new ArbolMenu();
        }
        return instancia;
    }

    public void insertar(Plato plato) {

        NodoPlato nuevo = new NodoPlato(plato);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRec(raiz, nuevo);
        }
    }

    private void insertarRec(NodoPlato actual, NodoPlato nuevo) {

        if (nuevo.getPlato().getNombre()
                .compareToIgnoreCase(actual.getPlato().getNombre()) < 0) {

            if (actual.getIzq() == null)
                actual.setIzq(nuevo);
            else
                insertarRec(actual.getIzq(), nuevo);

        } else {

            if (actual.getDer() == null)
                actual.setDer(nuevo);
            else
                insertarRec(actual.getDer(), nuevo);
        }
    }

    public String mostrarInOrden() {
        return mostrarInOrdenRec(raiz);
    }

    private String mostrarInOrdenRec(NodoPlato nodo) {
        if (nodo == null) {
            return "";
        }

        String resultado = "";
        resultado += mostrarInOrdenRec(nodo.getIzq());
        resultado += nodo.getPlato().getNombre() + " - $" + nodo.getPlato().getPrecio() + "\n";
        resultado += mostrarInOrdenRec(nodo.getDer());

        return resultado;
    }

    public java.util.List<Plato> obtenerPlatos() {
        java.util.List<Plato> platos = new java.util.ArrayList<>();
        obtenerPlatosRec(raiz, platos);
        return platos;
    }

    private void obtenerPlatosRec(NodoPlato nodo, java.util.List<Plato> platos) {
        if (nodo != null) {
            obtenerPlatosRec(nodo.getIzq(), platos);
            platos.add(nodo.getPlato());
            obtenerPlatosRec(nodo.getDer(), platos);
        }
    }
}
