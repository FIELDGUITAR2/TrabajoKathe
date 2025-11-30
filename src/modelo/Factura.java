package modelo;

import modelo.Cliente;

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
}
