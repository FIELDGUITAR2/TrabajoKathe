package modelo;

import modelo.Cliente;
import conexion.ConexionBD;
import conexion.FacturaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fieldguitar
 */
public class Factura {
    
    private int idFactura;
    private Cliente cliente;

    // Constructor por defecto
    public Factura() {
        this.idFactura = 0;
        this.cliente = null;
    }

    // Constructor con parámetros
    public Factura(int idFactura, Cliente cliente) {
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

    public int insertarFactura() {
        ConexionBD conexion = new ConexionBD();
        FacturaDAO facturaDAO = new FacturaDAO(0, this.cliente);
        conexion.abrir();
        conexion.ejecutar(facturaDAO.insertarFactura());
        int idFactura = obtenerUltimaFactura();
        conexion.cerrar();
        return idFactura;
    }

    public void insertarProductoEnFactura(int idProducto, int cantidad, double precioVenta) {
        ConexionBD conexion = new ConexionBD();
        FacturaDAO facturaDAO = new FacturaDAO();
        conexion.abrir();
        conexion.ejecutar(facturaDAO.insertarProductoEnFactura(this.idFactura, idProducto, cantidad, precioVenta));
        conexion.cerrar();
    }

    private int obtenerUltimaFactura() {
        ConexionBD conexion = new ConexionBD();
        FacturaDAO facturaDAO = new FacturaDAO();
        int idFactura = 0;
        try {
            ResultSet rs = conexion.ejecutarTF(facturaDAO.obtenerUltimaFactura());
            if (rs.next()) {
                idFactura = rs.getInt("ultimaFactura");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idFactura;
    }
}
