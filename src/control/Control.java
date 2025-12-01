package control;

import modelo.Producto;
import modelo.Factura;
import modelo.Cliente;
import vista.Formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Control implements ActionListener {

    private Formulario vista;
    private DefaultTableModel modeloTablaVenta;

    private List<Producto> productosEnFactura = new ArrayList<>();
    private double totalCompra = 0.0;

    public Control(Formulario vista) {
        this.vista = vista;
        this.modeloTablaVenta = (DefaultTableModel) vista.getjTable1().getModel();

        this.vista.getBtnInsertarEnFactura().addActionListener(this);
        this.vista.getBtnComprar().addActionListener(this);

        cargarProductosConStock();
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(vista, mensaje);
    }

    public void limpiarCampos() {
        vista.getTxtCantidad().setText("");
    }

    private void limpiarFactura() {
        modeloTablaVenta.setRowCount(0);
        productosEnFactura.clear();
        totalCompra = 0;
        limpiarCampos();
        cargarProductosConStock();
    }

    private void cargarProductosConStock() {
        Producto p = new Producto();
        List<Producto> productos = p.obtenerProductosConStock();

        vista.getCbSeleccionarPr().removeAllItems();
        for (Producto pr : productos) {
            vista.getCbSeleccionarPr().addItem(
                    pr.getNombre() + " (ID: " + pr.getId() + ")"
            );
        }
    }

    private int extraerIdProducto(String texto) {
        int inicio = texto.indexOf("(ID: ") + 5;
        int fin = texto.indexOf(")", inicio);
        return Integer.parseInt(texto.substring(inicio, fin).trim());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getBtnInsertarEnFactura()) {
            try {

                String seleccionado = (String) vista.getCbSeleccionarPr().getSelectedItem();
                if (seleccionado == null) {
                    mostrarMensaje("Seleccione un producto.");
                    return;
                }

                int idProducto = extraerIdProducto(seleccionado);

                String txtCantidad = vista.getTxtCantidad().getText().trim();
                if (txtCantidad.isEmpty()) {
                    mostrarMensaje("Ingrese la cantidad.");
                    return;
                }

                int cantidad = Integer.parseInt(txtCantidad);
                if (cantidad <= 0) {
                    mostrarMensaje("La cantidad debe ser mayor que 0.");
                    return;
                }

                // Buscar producto
                Producto prod = new Producto();
                Producto productoEncontrado = prod.buscarProductoPorId(idProducto);

                if (productoEncontrado == null) {
                    mostrarMensaje("Producto no encontrado.");
                    return;
                }

                double precioUnitario = productoEncontrado.getPrecio();
                double precioTotal = cantidad * precioUnitario;

                productosEnFactura.add(productoEncontrado);

                Object[] fila = {
                    productoEncontrado.getId(),
                    productoEncontrado.getNombre(),
                    cantidad,
                    precioUnitario,
                    precioTotal
                };

                modeloTablaVenta.addRow(fila);
                totalCompra += precioTotal;

                limpiarCampos();

            } catch (NumberFormatException ex) {
                mostrarMensaje("La cantidad debe ser un número válido.");
            } catch (Exception ex) {
                mostrarMensaje("Error al insertar producto: " + ex.getMessage());
            }
        }

        if (e.getSource() == vista.getBtnComprar()) {
            try {

                if (productosEnFactura.isEmpty()) {
                    mostrarMensaje("No hay productos en la factura.");
                    return;
                }

                // Cliente por defecto
                Cliente cliente = new Cliente(1, "Cliente General", "", "");

                // Crear y registrar factura
                Factura factura = new Factura();
                factura.setCliente(cliente);

                int idFactura = factura.insertarFactura();
                factura.setIdFactura(idFactura);

                // Guardar cada producto en BD + actualizar stock
                for (int i = 0; i < productosEnFactura.size(); i++) {
                    Producto producto = productosEnFactura.get(i);
                    int cantidad = (Integer) modeloTablaVenta.getValueAt(i, 2);
                    double precioUnitario = (Double) modeloTablaVenta.getValueAt(i, 3);

                    factura.insertarProductoEnFactura(producto.getId(), cantidad, precioUnitario);
                    producto.actualizarStock(cantidad);
                }

                mostrarMensaje(
                        "¡Compra realizada exitosamente!\n" +
                        "Factura: " + idFactura + "\n" +
                        "Total: $" + String.format("%.2f", totalCompra)
                );

                limpiarFactura();

            } catch (Exception ex) {
                mostrarMensaje("Error al realizar compra: " + ex.getMessage());
            }
        }
    }
}
