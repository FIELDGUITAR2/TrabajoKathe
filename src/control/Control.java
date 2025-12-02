package control;

import modelo.Producto;
import modelo.Factura;
import modelo.Cliente;
import modelo.Marca;
import modelo.TipoProducto;
import vista.Formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class Control implements ActionListener {

    private Formulario vista;
    private DefaultTableModel modeloTablaVenta;

    // Listas internas
    private List<Producto> productosEnFactura = new ArrayList<>();
    private List<Marca> marcasDisponibles = new ArrayList<>();
    private List<TipoProducto> tiposDisponibles = new ArrayList<>();
    private double totalCompra = 0.0;
    JComboBox<String> combo;

    public Control(Formulario vista) {
        this.vista = vista;
        this.modeloTablaVenta = (DefaultTableModel) vista.getjTable1().getModel();

        // Eventos
        this.vista.getBtnInsertarEnFactura().addActionListener(this);
        this.vista.getBtnComprar().addActionListener(this);
        this.vista.getBtnIngresarProducto().addActionListener(this);

        // Cargar listas al iniciar
        cargarCatalogosProducto();
        cargarProductosConStock();
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(vista, mensaje);
    }

    private void limpiarCampos() {
        vista.getTxtCantidad().setText("");
    }

    private void limpiarFactura() {
        modeloTablaVenta.setRowCount(0);
        productosEnFactura.clear();
        totalCompra = 0;
        limpiarCampos();
        cargarProductosConStock();
    }

    // -------------------------------------------------------------------------
    // ---------------------   CARGA DE COMBOBOXES    --------------------------
    // -------------------------------------------------------------------------

    private void cargarProductosConStock() {
        Producto p = new Producto();
        List<Producto> productos = p.obtenerProductosConStock();
        combo = new JComboBox<>();
        combo.removeAllItems();
        combo = vista.getCbSeleccionarPr();
        
        for(Producto a: productos) 
        {
            combo.addItem(a.getNombre());
        }
    }

    private void cargarCatalogosProducto() {
        try {
            // --- Marcas ---
            Marca marcaModelo = new Marca();
            marcasDisponibles = marcaModelo.consultarListaMarcas();

            vista.getCbMarca().removeAllItems();
            for (Marca marca : marcasDisponibles) {
                vista.getCbMarca().addItem(marca.getNombreMarca());
            }

            // --- Tipos ---
            TipoProducto tipoModelo = new TipoProducto();
            tiposDisponibles = tipoModelo.mostrarTiposProductos();

            vista.getCbTipo().removeAllItems();
            for (TipoProducto tipo : tiposDisponibles) {
                vista.getCbTipo().addItem(tipo.getNombreTipoProducto());
            }

        } catch (Exception e) {
            mostrarMensaje("Error al cargar catálogos: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // -------------------   INSERCIÓN DE NUEVO PRODUCTO   ----------------------
    // -------------------------------------------------------------------------

    private void limpiarFormularioProducto() {
        vista.getTxtNombreProducto().setText("");
        vista.getTxtPeso().setText("");
        vista.getTxtPrecio().setText("");
        vista.getTxtImei().setText("");
        vista.getCbMarca().setSelectedIndex(0);
        vista.getCbTipo().setSelectedIndex(0);
    }

    private void insertarNuevoProducto() {
        try {
            String nombre = vista.getTxtNombreProducto().getText().trim();
            if (nombre.isEmpty()) {
                mostrarMensaje("Ingrese el nombre del producto.");
                return;
            }

            int indexMarca = vista.getCbMarca().getSelectedIndex();
            int indexTipo  = vista.getCbTipo().getSelectedIndex();

            if (indexMarca < 0 || marcasDisponibles.isEmpty()) {
                mostrarMensaje("Debe seleccionar una marca.");
                return;
            }

            if (indexTipo < 0 || tiposDisponibles.isEmpty()) {
                mostrarMensaje("Debe seleccionar un tipo de producto.");
                return;
            }

            double peso = Double.parseDouble(vista.getTxtPeso().getText());
            double precio = Double.parseDouble(vista.getTxtPrecio().getText());

            if (peso <= 0 || precio <= 0) {
                mostrarMensaje("Peso y precio deben ser mayores que cero.");
                return;
            }

            String imei = vista.getTxtImei().getText().trim();

            // Construcción del producto
            Producto nuevo = new Producto();
            nuevo.setNombre(nombre);
            nuevo.setPeso(peso);
            nuevo.setPrecio(precio);
            nuevo.setMarca(marcasDisponibles.get(indexMarca));
            nuevo.setTipo(tiposDisponibles.get(indexTipo));
            nuevo.setImei(imei.isEmpty() ? null : imei);
            nuevo.setFragil(!imei.isEmpty());

            nuevo.insertarProducto();

            mostrarMensaje("Producto ingresado correctamente.");
            limpiarFormularioProducto();
            cargarProductosConStock();

        } catch (NumberFormatException e) {
            mostrarMensaje("Peso y precio deben ser números válidos.");
        } catch (Exception ex) {
            mostrarMensaje("Error al ingresar producto: " + ex.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // -------------------------   EVENTOS DE BOTONES    ------------------------
    // -------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {

        // ---------------------------------------------------------------------
        // BOTÓN: Insertar en factura
        // ---------------------------------------------------------------------
        if (e.getSource() == vista.getBtnInsertarEnFactura()) {
            try {

                Producto productoSeleccionado = 
                    (Producto) vista.getCbSeleccionarPr().getSelectedItem();

                if (productoSeleccionado == null) {
                    mostrarMensaje("Seleccione un producto.");
                    return;
                }

                int cantidad = Integer.parseInt(vista.getTxtCantidad().getText().trim());
                if (cantidad <= 0) {
                    mostrarMensaje("La cantidad debe ser mayor que 0.");
                    return;
                }

                double precioUnitario = productoSeleccionado.getPrecio();
                double precioTotal = cantidad * precioUnitario;

                productosEnFactura.add(productoSeleccionado);

                Object[] fila = {
                    productoSeleccionado.getId(),
                    productoSeleccionado.getNombre(),
                    cantidad,
                    precioUnitario,
                    precioTotal
                };

                modeloTablaVenta.addRow(fila);
                totalCompra += precioTotal;

                limpiarCampos();

            } catch (Exception ex) {
                mostrarMensaje("Error al insertar producto: " + ex.getMessage());
            }
            return;
        }

        // ---------------------------------------------------------------------
        // BOTÓN: Comprar
        // ---------------------------------------------------------------------
        if (e.getSource() == vista.getBtnComprar()) {
            try {

                if (productosEnFactura.isEmpty()) {
                    mostrarMensaje("No hay productos en la factura.");
                    return;
                }

                Cliente cliente = new Cliente(1, "Cliente General", "", "");

                Factura factura = new Factura();
                factura.setCliente(cliente);

                int idFactura = factura.insertarFactura();
                factura.setIdFactura(idFactura);

                // Guardar detalles de la factura
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
            return;
        }

        // ---------------------------------------------------------------------
        // BOTÓN: Ingresar producto
        // ---------------------------------------------------------------------
        if (e.getSource() == vista.getBtnIngresarProducto()) {
            insertarNuevoProducto();
        }
    }
}
