package conexion;


import modelo.Cliente;
/**
 *
 * @author fieldguitar
 */
public class FacturaDAO {
    
    private int idFactura;
    private Cliente cliente;

    // Constructor por defecto
    public FacturaDAO() {
        this.idFactura = 0;
        this.cliente = null;
    }

    // Constructor con parámetros
    public FacturaDAO(int idFactura, Cliente cliente) {
        this.idFactura = idFactura;
        this.cliente = cliente;
    }

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método toString opcional
    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + 
               ", cliente=" + (cliente != null ? cliente.getNombre() : "Sin cliente") + '}';
    }

    public String insertarFactura() {
        return "INSERT INTO factura(idCliente, fecha) "
                + "VALUES(" + this.cliente.getId() + ", CURDATE())";
    }

    public String insertarProductoEnFactura(int idFactura, int idProducto, int cantidad, double precioVenta) {
        return "INSERT INTO factura_producto(idFactura, idProducto, cantidad, precioVenta) "
                + "VALUES(" + idFactura + ", " + idProducto + ", " + cantidad + ", " + precioVenta + ")";
    }

    public String obtenerUltimaFactura() {
        return "SELECT MAX(idFactura) as ultimaFactura FROM factura";
    }
}
