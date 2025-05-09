package Estructuras.ArbolAVL;

public class NodoArbolAVL {
    private Comparable elemento;
    private NodoArbolAVL izquierdo;
    private NodoArbolAVL derecho;
    private int altura;

    public NodoArbolAVL(Comparable elElmento, NodoArbolAVL elIzquierdo, NodoArbolAVL elDerecho) {
        this.elemento = elElmento;
        this.izquierdo = elIzquierdo;
        this.derecho = elDerecho;
        this.altura = 1;
    }

    public Comparable getElemento() {
        return elemento;
    }

    public void setElemento(Comparable elElmento) {
        this.elemento = elElmento;
    }

    public NodoArbolAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbolAVL elIzquierdo) {
        this.izquierdo = elIzquierdo;
    }

    public NodoArbolAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbolAVL elDerecho) {
        this.derecho = elDerecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int laAltura) {
        this.altura = laAltura;
    }
}
