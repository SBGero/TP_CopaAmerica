package Estructuras.TablaHashAbierto;

import Estructuras.lineales.Nodo.Nodo;

public class TablaHash {
    private int tamaño=23;
    private Nodo [] tabla = new Nodo[tamaño];
    private int cant=0;

    public TablaHash(){};

    
    public boolean insertar (Object nuevoElem) {
        int pos = funcionHash(nuevoElem);
        //Nodo aux =this.tabla[pos];
        boolean encontrado = false;
        //while (!encontrado && aux != null) {
        //    encontrado = aux.getElemento().equals (nuevoElem);
        //        aux = aux.getEnlace();
        //
        //
        //}
        if (!encontrado) {
            this.tabla [pos] = new Nodo (nuevoElem, this.tabla[pos]);
            this.cant++;
        }
        
        return !encontrado;
    }

    public boolean eliminar(Object nuevoElem){
        int pos = funcionHash(nuevoElem);
        Nodo aux =this.tabla[pos];
        boolean encontrado = false;
            
        
        
        if (aux!=null) {
            encontrado = aux.getElemento().equals (nuevoElem);
            if (encontrado) {
                this.tabla[pos]=aux.getEnlace();
            }
        }

        if (!encontrado) {
            while (!encontrado && aux.getEnlace() != null) {
                encontrado = aux.getEnlace().getElemento().equals (nuevoElem);
                if (!encontrado) {
                    aux = aux.getEnlace();
                }
                
            }
            if (encontrado) {
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return !encontrado;
    }
    public boolean pertence(Object nuevoElem){
        
        int pos = funcionHash(nuevoElem);
        Nodo aux =this.tabla[pos];
        boolean encontrado = false;
        while (!encontrado && aux != null) {
            encontrado = aux.getElemento().equals (nuevoElem);
                aux = aux.getEnlace();
        }
        return encontrado;
    }

    //funcion HASH
    private int funcionHash(Object nuevoElem){
        int hash = nuevoElem.hashCode();
        int pos = (hash % this.tamaño + this.tamaño) % this.tamaño;
        return pos;
    }

    public String toString(){
        Nodo aux;
        String cadena = "";
        for (int i = 0; i < tabla.length; i++) {
            aux = tabla[i];
            while (aux!=null) {
                cadena += i+" "+aux.getElemento()+ " ";
                aux = aux.getEnlace();
            }

            
            
        }
        return cadena;
    }
}
