public class Articulo {

    private int idArticulo;
    private String nombreArticulo;
    private int cantArticulo;
    private float costoArticulo;

    public Articulo() {

    }

    public Articulo(int idArticulo, String nombreArticulo, int cantArticulo, float costoArticulo) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantArticulo = cantArticulo;
        this.costoArticulo = costoArticulo;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getCantArticulo() {
        return cantArticulo;
    }

    public void setCantArticulo(int cantArticulo) {
        this.cantArticulo = cantArticulo;
    }

    public float getCostoArticulo() {
        return costoArticulo;
    }

    public void setCostoArticulo(float costoArticulo) {
        this.costoArticulo = costoArticulo;
    }
    @Override
    public String toString() {
        return "ID=" + idArticulo + ", nombre=" + nombreArticulo + ", cantidad=" + cantArticulo +", costo=" + costoArticulo;
    }

}
