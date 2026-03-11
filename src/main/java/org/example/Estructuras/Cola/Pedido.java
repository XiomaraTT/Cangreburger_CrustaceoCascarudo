package org.example.Estructuras.Cola;

import org.example.Estructuras.Lista.Cliente;
import org.example.Estructuras.Arbol.Plato;
import org.example.Estructuras.Arreglo.Mesa;
import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plato_id")
    private Plato plato;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mesa_numero")
    private Mesa mesa;

    @Column
    private int cantidad;

    @Transient  // No existe en la BD, solo se usa en memoria
    private int prioridad = 0;

    @Column(length = 20)
    private String estado;

    public Pedido() {}

    public Pedido(Cliente cliente, Plato plato, Mesa mesa, int cantidad, int prioridad, String estado) {
        this.cliente = cliente;
        this.plato = plato;
        this.mesa = mesa;
        this.cantidad = cantidad;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Plato getPlato() {
        return plato;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return cliente + " pidió " + plato + " (Prioridad: " + prioridad + ")";
    }
}
