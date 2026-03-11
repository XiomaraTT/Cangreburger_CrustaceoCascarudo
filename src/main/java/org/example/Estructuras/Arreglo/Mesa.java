package org.example.Estructuras.Arreglo;

import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesa {
    @Id
    @Column(name = "numero")
    private int numero;

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false)
    private boolean ocupada;

    public Mesa() {
        // constructor vacío requerido por JPA
    }

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocuparMesa() {
        ocupada = true;
    }

    public void liberarMesa() {
        ocupada = false;
    }

    @Override
    public String toString() {
        return "Mesa " + numero +
                " | Capacidad: " + capacidad +
                " | Estado: " + (ocupada ? "Ocupada" : "Libre");
    }
}
