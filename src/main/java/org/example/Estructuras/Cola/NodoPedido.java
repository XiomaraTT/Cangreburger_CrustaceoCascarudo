package org.example.Estructuras.Cola;

public class NodoPedido {
    private Pedido pedido;
    private NodoPedido siguiente;

    public NodoPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public NodoPedido getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPedido siguiente) {
        this.siguiente = siguiente;
    }
}

