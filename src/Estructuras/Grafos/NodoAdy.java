package Estructuras.Grafos;

public class NodoAdy {
    private NodoVert vert;
    private NodoAdy sigAdy;

    public NodoAdy(NodoVert elVert, NodoAdy elSigAdy){
        vert= elVert;
        sigAdy = elSigAdy;
    }
    public NodoVert getVert(){
        return this.vert;
    }
    public NodoAdy getSigAdy(){
        return this.sigAdy;
    }
    public void setVert(NodoVert elVert){
        vert = elVert;
    }
    public void setSigAdy(NodoAdy elSigAdy){
        sigAdy = elSigAdy;
    }
}
