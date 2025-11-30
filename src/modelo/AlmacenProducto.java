package modelo;

/**
 *
 * @author fieldguitar
 */
public class AlmacenProducto {
    
    private Almacen almacen;
    private Producto producto;
    private EstadoAlmacenProducto estAlmPro;
    private int cantidad;

    // Constructor por defecto
    public AlmacenProducto() {
        this.almacen = null;
        this.producto = null;
        this.estAlmPro = null;
        this.cantidad = 0;
    }

    // Constructor con parámetros
    public AlmacenProducto(Almacen almacen, Producto producto, 
                           EstadoAlmacenProducto estAlmPro, int cantidad) {
        this.almacen = almacen;
        this.producto = producto;
        this.estAlmPro = estAlmPro;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public EstadoAlmacenProducto getEstAlmPro() {
        return estAlmPro;
    }

    public void setEstAlmPro(EstadoAlmacenProducto estAlmPro) {
        this.estAlmPro = estAlmPro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método toString para depuración y visualización
    @Override
    public String toString() {
        return "AlmacenProducto{" +
                "almacen=" + almacen +
                ", producto=" + producto +
                ", estAlmPro=" + estAlmPro +
                ", cantidad=" + cantidad +
                '}';
    }
}
