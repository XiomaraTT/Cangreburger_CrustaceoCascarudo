package org.example.Estructuras.Arbol;

public class NodoPlato {
    //Nodo del arbol
    private Plato plato;
    private NodoPlato izq, der;

    public NodoPlato(Plato plato) {
        this.plato = plato;
    }

    public Plato getPlato() {
        return plato;
    }

    public NodoPlato getIzq() {
        return izq;
    }

    public void setIzq(NodoPlato izq) {
        this.izq = izq;
    }

    public NodoPlato getDer() {
        return der;
    }

    public void setDer(NodoPlato der) {
        this.der = der;
    }
}

