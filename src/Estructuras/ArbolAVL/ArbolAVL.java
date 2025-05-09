package Estructuras.ArbolAVL;

import Estructuras.lineales.listaDinamica.Lista;

public class ArbolAVL {
    
    NodoArbolAVL raiz;

    public ArbolAVL(){
        raiz=null;
    }
    public boolean insertar(Comparable elem) {
        this.raiz=insertarAux(this.raiz, elem);
        
        return true;
    }
    
    private NodoArbolAVL insertarAux(NodoArbolAVL nodo, Comparable elem) {
        NodoArbolAVL nodoAux=null;
        if (nodo == null) {
            nodoAux= new NodoArbolAVL(elem, null, null);
        }
        if(nodo!=null){
            if (elem.compareTo(nodo.getElemento()) < 0) {
                nodo.setIzquierdo(insertarAux(nodo.getIzquierdo(), elem));
            } else if (elem.compareTo(nodo.getElemento()) > 0) {
                nodo.setDerecho(insertarAux(nodo.getDerecho(), elem));
            }
        }
        
        if (nodo!=null) {
            actualizarAltura(nodo);
            nodoAux=balancear(nodo);
        }
        
        return nodoAux;
    }
    
    private void actualizarAltura(NodoArbolAVL nodo) {
        int alturaIzquierda = (nodo.getIzquierdo() != null) ? nodo.getIzquierdo().getAltura() : 0;
        int alturaDerecha = (nodo.getDerecho() != null) ? nodo.getDerecho().getAltura() : 0;
        nodo.setAltura(1 + Math.max(alturaIzquierda, alturaDerecha));
    }
    
    private NodoArbolAVL balancear(NodoArbolAVL nodo) {
        int balance = obtenerBalance(nodo);
    
        if (balance > 1) {
            if (obtenerBalance(nodo.getIzquierdo()) < 0) {
                nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
            }
            return rotarDerecha(nodo);
        } else if (balance < -1) {
            if (obtenerBalance(nodo.getDerecho()) > 0) {
                nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            }
            return rotarIzquierda(nodo);
        }
    
        return nodo; // El nodo está balanceado
    }
    
    private int obtenerBalance(NodoArbolAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = (nodo.getIzquierdo() != null) ? nodo.getIzquierdo().getAltura() : 0;
        int alturaDerecha = (nodo.getDerecho() != null) ? nodo.getDerecho().getAltura() : 0;
        return alturaIzquierda - alturaDerecha;
    }
    
    private NodoArbolAVL rotarDerecha(NodoArbolAVL nodo) {
        NodoArbolAVL nuevaRaiz = nodo.getIzquierdo();
        nodo.setIzquierdo(nuevaRaiz.getDerecho());
        nuevaRaiz.setDerecho(nodo);
        actualizarAltura(nodo);
        actualizarAltura(nuevaRaiz);
        return nuevaRaiz;
    }
    
    private NodoArbolAVL rotarIzquierda(NodoArbolAVL nodo) {
        NodoArbolAVL nuevaRaiz = nodo.getDerecho();
        nodo.setDerecho(nuevaRaiz.getIzquierdo());
        nuevaRaiz.setIzquierdo(nodo);
        actualizarAltura(nodo);
        actualizarAltura(nuevaRaiz);
        return nuevaRaiz;
    }
    

    public boolean eliminar(Comparable elem) {
        boolean resultado = false;
        if (this.raiz != null) {
            this.raiz = eliminarAux(this.raiz, elem);
            resultado = true;
        }
        return resultado;
    }
    
    private NodoArbolAVL eliminarAux(NodoArbolAVL nodo, Comparable elem) {
        NodoArbolAVL resultado = nodo;
    
        if (nodo != null) {
            if (elem.compareTo(nodo.getElemento()) < 0) {
                nodo.setIzquierdo(eliminarAux(nodo.getIzquierdo(), elem));
            } else if (elem.compareTo(nodo.getElemento()) > 0) {
                nodo.setDerecho(eliminarAux(nodo.getDerecho(), elem));
            } else {
                if (nodo.getIzquierdo() == null) {
                    resultado = nodo.getDerecho();
                } else if (nodo.getDerecho() == null) {
                    resultado = nodo.getIzquierdo();
                } else {
                    NodoArbolAVL sucesor = encontrarMinimo(nodo.getDerecho());
                    nodo.setElemento(sucesor.getElemento());
                    nodo.setDerecho(eliminarAux(nodo.getDerecho(), sucesor.getElemento()));
                }
            }
    
            if (resultado != null) {
                actualizarAltura(resultado);
                resultado = balancear(resultado);
            }
        }
    
        return resultado;
    }
    
    private NodoArbolAVL encontrarMinimo(NodoArbolAVL nodo) {
        NodoArbolAVL actual = nodo;
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual;
    }
    
    
    
    public boolean pertence(Comparable elem){
        boolean exito = false;
        if (this.raiz != null) {
            exito= pertenceAux(raiz, elem);
        }
        return exito;
    }
    private boolean pertenceAux(NodoArbolAVL ra, Comparable elem){
        boolean exito= false;
        if (ra!=null) {
            if (elem.compareTo(ra.getElemento())==0) {
                exito = true;
            }else if (elem.compareTo(ra.getElemento())<0) {
            
                exito= pertenceAux(ra.getIzquierdo(), elem);
                
            }else{
                exito= pertenceAux(ra.getDerecho(), elem);
            }
        }
        return exito;
    }




    
    public boolean esVacio(){
        return this.raiz==null;
    }
    public Object maxElem(){
        Object max=null;
        if (raiz!=null) {
            max=maxElemAux(raiz);
        }
        
        return max;
    }
    private Object maxElemAux(NodoArbolAVL ra){
        Object max=null;
        if (ra!=null) {
            if (ra.getDerecho()!=null) {
                max=maxElemAux(ra.getDerecho());
            }else{
                max=ra.getElemento();
            }
        }
        return max;
    }

    public Object minElem(){
        Object max=null;
        if (raiz!=null) {
            max=minElemAux(raiz);
        }
        return max;
    }
    private Object minElemAux(NodoArbolAVL ra){
        Object max=null;
        if (ra!=null) {
            if (ra.getIzquierdo()!=null) {
                max=minElemAux(ra.getIzquierdo());
            }else{
                max=ra.getElemento();
            }
        }
        return max;
    }
    public Lista listarPorRango(Comparable min, Comparable max){
        Lista list=new Lista();
        listarPorRangoAux(min, max, raiz,list);
        return list;
    }
    private void listarPorRangoAux(Comparable min, Comparable max, NodoArbolAVL ra, Lista list){
        if (ra!=null) {
            if (min.compareTo(ra.getElemento())<0) {
                listarPorRangoAux(min, max, ra.getIzquierdo(),list);
                
            }
            if (min.compareTo(ra.getElemento())<=0 && max.compareTo(ra.getElemento())>=0) {
                list.insertar(ra.getElemento(), list.longitud()+1);
            }
            
            if (min.compareTo(ra.getElemento())>0) {
                listarPorRangoAux(min, max, ra.getDerecho(),list);
            }

            
        }

    }

//Listado-----------------------------------------------
            public Lista listaPreorden(){
            Lista lis = new Lista();
            listaPreordenAux( lis, this.raiz);
            return lis;
        }
        private void listaPreordenAux( Lista lis, NodoArbolAVL n){
        if (n!=null) {
            
            lis.insertar(n.getElemento(), lis.longitud()+1);
            listaPreordenAux(lis,n.getIzquierdo());
            listaPreordenAux(lis, n.getDerecho());
        }
        }
        public Lista listarInorden(){
            Lista lis = new Lista();
            listarInordenAux( lis, this.raiz);
            return lis;
        }
        public void listarInordenAux(Lista lis, NodoArbolAVL n){
            
            if (n != null) {
                
                listarInordenAux(lis,n.getIzquierdo());
                lis.insertar(n.getElemento(), lis.longitud()+1);
                listarInordenAux(lis, n.getDerecho());
            }
        }

        public Lista listarPosOrden(){
            Lista lis = new Lista();
            listarPosOrdenAux( lis, this.raiz);
            return lis;
        }
        public void listarPosOrdenAux(Lista lis, NodoArbolAVL n){
            
            if (n != null) {
                
                listarPosOrdenAux(lis,n.getIzquierdo());
                listarPosOrdenAux(lis, n.getDerecho());
                lis.insertar(n.getElemento(), lis.longitud()+1);
            }
        }
        //public ArbolBinBusqueda clonarInvertido(){
        //    ArbolBinBusqueda arbolito = new ArbolBinBusqueda();
        //    if (raiz!=null) {
        //        arbolito.raiz= clonarInvertidoAux(raiz);
        //        
        //    }
        //    return arbolito;
        //}
        //private NodoArbolBin clonarInvertidoAux(NodoArbolBin raiz){
        //    NodoArbolBin nuevo = null;
        //    Comparable aux;
        //    if (raiz!=null) {
        //        nuevo = new NodoArbolBin(raiz.getElemento(), clonarInvertidoAux(raiz.getDerecho()), clonarInvertidoAux( raiz.getIzquierdo()));
        //        
        //    }
        //    return nuevo;
        //}
}
