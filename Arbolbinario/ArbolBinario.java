import java.util.*;
public class ArbolBinario {
    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void agregarNodo(int generacion, String nom) {
        NodoArbol nodoArbol = new NodoArbol(generacion, nom);
        if (raiz == null) {
            raiz = nodoArbol;
        } else {
            NodoArbol aux = raiz;
            NodoArbol padre;
            while (true) {
                padre = aux;
                if (generacion < aux.dato) {
                    aux = aux.hijoIzquierdo;
                    if (aux == null) {
                        padre.hijoIzquierdo = nodoArbol;
                        return;
                    }
                }else {
                    aux=aux.hijoDerecho;
                    if (aux==null){
                        padre.hijoDerecho=nodoArbol;
                        return;
                    }
                }
            }
        }
    }
    public void imprimirArbol() {
        imprimirNodo(raiz, 0);
    }

    private void imprimirNodo(NodoArbol nodoArbol, int nivel) {
        if (nodoArbol != null) {
            StringBuilder espacios = new StringBuilder();
            for (int i = 0; i < nodoArbol.dato; i++) {
                espacios.append("  ");
            }
            System.out.println(espacios + "Generación: " + nodoArbol.dato + " " + nodoArbol.nombre);

            imprimirNodo(nodoArbol.hijoIzquierdo, nivel + 1);
            imprimirNodo(nodoArbol.hijoDerecho, nivel + 1);
        }
    }

}
