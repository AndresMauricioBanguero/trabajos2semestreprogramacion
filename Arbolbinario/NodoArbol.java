public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;
    public NodoArbol(int generacion, String nom) {
        this.dato = generacion;
        this.nombre = nom;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    @Override
    public String toString() {
        return "NodoArbol{" +
                "dato=" + dato +
                ", nombre='" + nombre + '\'' +
                ", hijoIzquierdo=" + hijoIzquierdo +
                ", hijoDerecho=" + hijoDerecho +
                '}';
    }
}