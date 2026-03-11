package org.example.Patrones;

/**
 * =====================================================
 * PATRÓN DE DISEÑO: SINGLETON
 * =====================================================
 *
 * El patrón Singleton garantiza que una clase tenga una única
 * instancia y proporciona un punto de acceso global a ella.
 *
 * CARACTERÍSTICAS:
 * - Constructor privado para evitar instanciación externa
 * - Variable estática que almacena la única instancia
 * - Método estático público para obtener la instancia
 *
 * CLASES QUE IMPLEMENTAN SINGLETON EN ESTE PROYECTO:
 * - ListaClientes (Lista Enlazada)
 * - ColaPedidos (Cola FIFO)
 * - ArregloMesas (Arreglo)
 * - PilaHistorial (Pila LIFO)
 * - ArbolMenu (Árbol Binario de Búsqueda)
 *
 * BENEFICIOS:
 * - Control estricto sobre cómo y cuándo se accede a la instancia
 * - Reduce el uso de memoria al no crear múltiples instancias
 * - Proporciona un punto de acceso global consistente
 *
 * @author Sistema Cangreburger
 */
public interface Singleton<T> {

    /**
     * Método que debe implementarse para obtener la instancia única.
     * Cada clase Singleton implementa su propia versión estática.
     *
     * Ejemplo de implementación:
     * <pre>
     * private static MiClase instancia;
     *
     * private MiClase() { }
     *
     * public static MiClase getInstancia() {
     *     if (instancia == null) {
     *         instancia = new MiClase();
     *     }
     *     return instancia;
     * }
     * </pre>
     */
}

