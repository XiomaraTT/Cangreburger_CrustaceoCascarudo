package org.example.Patrones;

/**
 * =====================================================
 * GESTOR DE INSTANCIAS SINGLETON
 * =====================================================
 *
 * Esta clase centraliza el acceso a todas las instancias
 * Singleton del proyecto, proporcionando un único punto
 * de acceso para obtener las estructuras de datos.
 *
 * @author Sistema Cangreburger
 */
public class SingletonManager {

    /**
     * Obtiene la instancia única de ListaClientes
     * Estructura: Lista Enlazada Simple
     */
    public static org.example.Estructuras.Lista.ListaClientes getListaClientes() {
        return org.example.Estructuras.Lista.ListaClientes.getInstancia();
    }

    /**
     * Obtiene la instancia única de ColaPedidos
     * Estructura: Cola FIFO (First In, First Out)
     */
    public static org.example.Estructuras.Cola.ColaPedidos getColaPedidos() {
        return org.example.Estructuras.Cola.ColaPedidos.getInstancia();
    }

    /**
     * Obtiene la instancia única de ArregloMesas
     * Estructura: Arreglo estático
     */
    public static org.example.Estructuras.Arreglo.ArregloMesas getArregloMesas() {
        return org.example.Estructuras.Arreglo.ArregloMesas.getInstancia();
    }

    /**
     * Obtiene la instancia única de PilaHistorial
     * Estructura: Pila LIFO (Last In, First Out)
     */
    public static org.example.Estructuras.Pila.PilaHistorial getPilaHistorial() {
        return org.example.Estructuras.Pila.PilaHistorial.getInstancia();
    }

    /**
     * Obtiene la instancia única de ArbolMenu
     * Estructura: Árbol Binario de Búsqueda (BST)
     */
    public static org.example.Estructuras.Arbol.ArbolMenu getArbolMenu() {
        return org.example.Estructuras.Arbol.ArbolMenu.getInstancia();
    }

    /**
     * Información sobre el patrón implementado
     */
    public static String getPatronInfo() {
        return """
            ╔═══════════════════════════════════════════════════════════╗
            ║           PATRÓN DE DISEÑO: SINGLETON                     ║
            ╠═══════════════════════════════════════════════════════════╣
            ║ Garantiza una única instancia de cada estructura          ║
            ║                                                           ║
            ║ Implementaciones:                                         ║
            ║   • ListaClientes  → Lista Enlazada                       ║
            ║   • ColaPedidos    → Cola FIFO                            ║
            ║   • ArregloMesas   → Arreglo                              ║
            ║   • PilaHistorial  → Pila LIFO                            ║
            ║   • ArbolMenu      → Árbol Binario de Búsqueda            ║
            ╚═══════════════════════════════════════════════════════════╝
            """;
    }
}

