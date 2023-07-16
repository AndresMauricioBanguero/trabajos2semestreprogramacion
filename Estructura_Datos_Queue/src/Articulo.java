public class Articulo {
    private final int id;
    private final String nombre;
    private final int cantidad;
    private final float costo;

    public Articulo(int id, String nombre, int cantidad, float costo) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Nombre=" + nombre + ", Cantidad=" + cantidad + ", Costo=" + costo;
    }
}
