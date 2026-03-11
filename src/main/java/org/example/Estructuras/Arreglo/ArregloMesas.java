package org.example.Estructuras.Arreglo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase ArregloMesas - Implementa el patrón Singleton
 * Garantiza una única instancia del arreglo de mesas en toda la aplicación
 */
public class ArregloMesas {

    // Instancia única (Singleton)
    private static ArregloMesas instancia;
    private static final int CAPACIDAD_DEFAULT = 20;

    private Mesa[] mesas;
    private int contador;

    // Constructor privado (Singleton)
    private ArregloMesas(int tamanio) {
        mesas = new Mesa[tamanio];
        contador = 0;
    }

    // Método para obtener la instancia única (Singleton)
    public static ArregloMesas getInstancia() {
        if (instancia == null) {
            instancia = new ArregloMesas(CAPACIDAD_DEFAULT);
        }
        return instancia;
    }

    // Método para obtener instancia con tamaño específico
    public static ArregloMesas getInstancia(int tamanio) {
        if (instancia == null) {
            instancia = new ArregloMesas(tamanio);
        }
        return instancia;
    }

    // Limpiar el arreglo (para recargar desde BD)
    public void limpiar() {
        for (int i = 0; i < contador; i++) {
            mesas[i] = null;
        }
        contador = 0;
    }

    // Agregar mesa con objeto Mesa
    public boolean agregarMesa(Mesa mesa) {
        if (contador < mesas.length) {
            mesas[contador] = mesa;
            contador++;
            return true;
        }
        return false;
    }

    // Agregar mesa con numero y capacidad
    public String agregarMesa(int numero, int capacidad) {
        if (contador < mesas.length) {
            mesas[contador] = new Mesa(numero, capacidad);
            contador++;
            return "Mesa agregada correctamente";
        } else {
            return "No hay espacio para mas mesas";
        }
    }

    // Buscar mesa por numero
    public Mesa buscarMesa(int numero) {
        for (int i = 0; i < contador; i++) {
            if (mesas[i].getNumero() == numero) {
                return mesas[i];
            }
        }
        return null;
    }

    // Ocupar mesa por numero
    public String ocuparMesa(int numero) {
        for (int i = 0; i < contador; i++) {
            if (mesas[i].getNumero() == numero) {
                mesas[i].ocuparMesa();
                return "Mesa ocupada";
            }
        }
        return "Mesa no encontrada";
    }

    // Liberar mesa por numero
    public String liberarMesa(int numero) {
        for (int i = 0; i < contador; i++) {
            if (mesas[i].getNumero() == numero) {
                mesas[i].liberarMesa();
                return "Mesa liberada";
            }
        }
        return "Mesa no encontrada";
    }

    // Contar mesas libres
    public int contarLibres() {
        int libres = 0;
        for (int i = 0; i < contador; i++) {
            if (!mesas[i].isOcupada()) {
                libres++;
            }
        }
        return libres;
    }

    // Contar mesas ocupadas
    public int contarOcupadas() {
        int ocupadas = 0;
        for (int i = 0; i < contador; i++) {
            if (mesas[i].isOcupada()) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    // Obtener el contador (cantidad de mesas en el arreglo)
    public int getContador() {
        return contador;
    }

    // Obtener capacidad maxima del arreglo
    public int getCapacidad() {
        return mesas.length;
    }

    // Obtener todas las mesas como lista (para mostrar en la vista)
    public List<Mesa> obtenerMesas() {
        List<Mesa> lista = new ArrayList<>();
        for (int i = 0; i < contador; i++) {
            lista.add(mesas[i]);
        }
        return lista;
    }

    // Mostrar mesas como texto
    public String mostrarMesas() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            resultado.append(mesas[i].toString()).append("\n");
        }
        return resultado.toString();
    }
}
