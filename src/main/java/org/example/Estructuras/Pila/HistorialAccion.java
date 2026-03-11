package org.example.Estructuras.Pila;

import jakarta.persistence.*;

@Entity
@Table(name = "historial_acciones")
public class HistorialAccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String descripcion; // Ej: "Preparó Cangreburger Doble"

    @Column(name = "fecha")
    private String fechaHora;   // Texto con fecha y hora

    public HistorialAccion() {
        // constructor vacío requerido por JPA
    }

    public HistorialAccion(String descripcion, String fechaHora) {
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
}

