package Estructuras.Grafos;

import Estructuras.lineales.listaDinamica.Lista;

public class Grafo {
    private NodoVert inicio;

    public Grafo() {
        inicio = null;
    }

    public boolean insertarVertice(Object nuevoVertice) {
        boolean exito = false;
        NodoVert aux = ubicarVertice(nuevoVertice);
        if (aux == null) {
            this.inicio = new NodoVert(this.inicio, null, nuevoVertice);
            exito = true;
        }
        return exito;
    }

    private NodoVert ubicarVertice(Object buscado) {
        NodoVert aux = this.inicio;
        while (aux != null && !aux.getElem().equals(buscado)) {
            aux = aux.getSigVert();
        }
        return aux;
    }

    public boolean eliminarVertice(Object vertice) {
        boolean exito = false;
        NodoVert aux = this.inicio;
        NodoVert anterior = null;

        while (aux != null && !aux.getElem().equals(vertice)) {
            anterior = aux;
            aux = aux.getSigVert();
        }

        if (aux != null) {
            if (anterior == null) {
                this.inicio = aux.getSigVert();
            } else {
                anterior.setSigVert(aux.getSigVert());
            }
            // Eliminar los arcos asociados
            NodoVert aux2 = this.inicio;
            while (aux2 != null) {
                NodoAdy adyacente = aux2.getAdy();
                NodoAdy anteriorAdyacente = null;
                while (adyacente != null) {
                    if (adyacente.getVert().equals(aux)) {
                        if (anteriorAdyacente == null) {
                            aux2.setAdy(adyacente.getSigAdy());
                        } else {
                            anteriorAdyacente.setSigAdy(adyacente.getSigAdy());
                        }
                    }
                    anteriorAdyacente = adyacente;
                    adyacente = adyacente.getSigAdy();
                }
                aux2 = aux2.getSigVert();
            }

            exito = true;
        }

        return exito;
    }

    public boolean insertarArco(Object origen, Object destino) {
        boolean exito = false;
        NodoVert nodoOrigen = ubicarVertice(origen);
        NodoVert nodoDestino = ubicarVertice(destino);

        if (nodoOrigen != null && nodoDestino != null) {
            NodoAdy adyacente = nodoOrigen.getAdy();
            while (adyacente != null && !adyacente.getVert().getElem().equals(destino)) {
                adyacente = adyacente.getSigAdy();
            }
            if (adyacente == null) {
                nodoOrigen.setAdy(new NodoAdy(nodoDestino, nodoOrigen.getAdy()));
                exito = true;
            }
        }
        return exito;
    }

    public boolean eliminarArco(Object origen, Object destino) {
        boolean exito = false;
        NodoVert nodoOrigen = ubicarVertice(origen);
        NodoVert nodoDestino = ubicarVertice(destino);

        if (nodoOrigen != null && nodoDestino != null) {
            NodoAdy adyacente = nodoOrigen.getAdy();
            NodoAdy anterior = null;
            while (adyacente != null && !adyacente.getVert().getElem().equals(destino)) {
                anterior = adyacente;
                adyacente = adyacente.getSigAdy();
            }
            if (adyacente != null) {
                if (anterior == null) {
                    nodoOrigen.setAdy(adyacente.getSigAdy());
                } else {
                    anterior.setSigAdy(adyacente.getSigAdy());
                }
                exito = true;
            }
        }
        return exito;
    }

    

    public boolean existeVertice(Object vertice) {
        return ubicarVertice(vertice) != null;
    }

    public boolean existeArco(Object origen, Object destino) {
        NodoVert nodoOrigen = ubicarVertice(origen);
        if (nodoOrigen != null) {
            NodoAdy adyacente = nodoOrigen.getAdy();
            while (adyacente != null) {
                if (adyacente.getVert().getElem().equals(destino)) {
                    return true;
                }
                adyacente = adyacente.getSigAdy();
            }
        }
        return false;
    }

    public Lista listarEnProfundidad() {
        Lista visitados = new Lista();
        NodoVert aux = this.inicio;
        while (aux != null) {
            if (visitados.localizar(aux.getElem()) < 0) {
                listarEnProfundidadAux(aux, visitados);
            }
            aux = aux.getSigVert();
        }
        return visitados;
    }

    private void listarEnProfundidadAux(NodoVert n, Lista vis) {
        if (n != null) {
            vis.insertar(n.getElem(), vis.longitud() + 1);
            NodoAdy ady = n.getAdy();
            while (ady != null) {
                if (vis.localizar(ady.getVert().getElem()) < 0) {
                    listarEnProfundidadAux(ady.getVert(), vis);
                }
                ady = ady.getSigAdy();
            }
        }
    }

    public boolean existeCamino(Object origen, Object destino) {
        boolean exito = false;
        NodoVert nodoOrigen = null;
        NodoVert nodoDestino = null;
        NodoVert aux = this.inicio;

        while ((nodoOrigen == null || nodoDestino == null) && aux != null) {
            if (aux.getElem().equals(origen)) nodoOrigen = aux;
            if (aux.getElem().equals(destino)) nodoDestino = aux;
            aux = aux.getSigVert();
        }

        if (nodoOrigen != null && nodoDestino != null) {
            Lista visitados = new Lista();
            exito = existeCaminoAux(nodoOrigen, destino, visitados);
        }
        return exito;
    }

    private boolean existeCaminoAux(NodoVert n, Object dest, Lista vis) {
        boolean exito = false;

        if (n != null) {
            if (n.getElem().equals(dest)) {
                exito = true;
            } else {
                vis.insertar(n.getElem(), vis.longitud() + 1);
                NodoAdy ady = n.getAdy();
                while (!exito && ady != null) {
                    if (vis.localizar(ady.getVert().getElem()) < 0) {
                        exito = existeCaminoAux(ady.getVert(), dest, vis);
                    }
                    ady = ady.getSigAdy();
                }
            }
        }
        return exito;
    }
}
