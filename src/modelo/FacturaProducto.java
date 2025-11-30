package modelo;

/**
 *
 * @author fieldguitar
 */
public class FacturaProducto {
    
    private Factura factura;
    private Producto producto;

    // Constructor por defecto
    public FacturaProducto() {
        this.factura = null;
        this.producto = null;
    }

    // Constructor con parámetros
    public FacturaProducto(Factura factura, Producto producto) {
        this.factura = factura;
        this.producto = producto;
    }

    // Getters y Setters
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "FacturaProducto{" +
                "factura=" + factura +
                ", producto=" + producto +
                '}';
    }
}
