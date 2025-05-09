package Estructuras.Grafos;

public class NodoVert {
    private NodoVert sigvert;
    private NodoAdy ady;
    private Object elem;

    public NodoVert(NodoVert elSigVert, NodoAdy elAdy, Object elElem){
        sigvert = elSigVert;
        ady = elAdy;
        elem = elElem;
    }
    public NodoVert getSigVert(){
        return this.sigvert;
    }
    public NodoAdy getAdy(){
        return this.ady;
    }
    public Object getElem(){
        return this.elem;
    }
    public void setSigVert(NodoVert elvert){
        sigvert = elvert;
    }
    public void setAdy(NodoAdy elAdy){
        ady= elAdy;
    }
    public void setElem(Object elElem){
        elem = elElem;
    }
}
