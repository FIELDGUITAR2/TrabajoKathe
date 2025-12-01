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

public class Control implements ActionListener {

    private Formulario vista;
    private DefaultTableModel modeloTablaVenta;

    private List<Producto> productosEnFactura = new ArrayList<>();
    private List<Marca> marcasDisponibles = new ArrayList<>();
    private List<TipoProducto> tiposDisponibles = new ArrayList<>();
    private double totalCompra = 0.0;

    public Control(Formulario vista) {
        this.vista = vista;
        this.modeloTablaVenta = (DefaultTableModel) vista.getjTable1().getModel();

        this.vista.getBtnInsertarEnFactura().addActionListener(this);
        this.vista.getBtnComprar().addActionListener(this);
        this.vista.getBtnIngresarProducto().addActionListener(this);

        cargarCatalogosProducto();
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

    private void cargarCatalogosProducto() {
        try {
            Marca marcaModelo = new Marca();
            marcasDisponibles = marcaModelo.consultarListaMarcas();
            vista.getCbMarca().removeAllItems();
            for (Marca marca : marcasDisponibles) {
                vista.getCbMarca().addItem(marca.getNombreMarca());
            }

            TipoProducto tipoModelo = new TipoProducto();
            tiposDisponibles = tipoModelo.consultarListaTiposProducto();
            vista.getCbTipo().removeAllItems();
            for (TipoProducto tipo : tiposDisponibles) {
                vista.getCbTipo().addItem(tipo.getNombreTipoProducto());
            }
        } catch (Exception e) {
            mostrarMensaje("Error al cargar catálogos: " + e.getMessage());
        }
    }

    private void limpiarFormularioProducto() {
        vista.getTxtNombreProducto().setText("");
        vista.getTxtPeso().setText("");
        vista.getTxtPrecio().setText("");
        vista.getTxtImei().setText("");
        if (vista.getCbMarca().getItemCount() > 0) {
            vista.getCbMarca().setSelectedIndex(0);
        }
        if (vista.getCbTipo().getItemCount() > 0) {
            vista.getCbTipo().setSelectedIndex(0);
        }
    }

    private int extraerIdProducto(String texto) {
        int inicio = texto.indexOf("(ID: ") + 5;
        int fin = texto.indexOf(")", inicio);
        return Integer.parseInt(texto.substring(inicio, fin).trim());
    }

    private void insertarNuevoProducto() {
        try {
            String nombre = vista.getTxtNombreProducto().getText().trim();
            if (nombre.isEmpty()) {
                mostrarMensaje("Ingrese el nombre del producto.");
                return;
            }

            if (marcasDisponibles.isEmpty()) {
                mostrarMensaje("No hay marcas registradas.");
                return;
            }

            if (tiposDisponibles.isEmpty()) {
                mostrarMensaje("No hay tipos de producto registrados.");
                return;
            }

            int indiceMarca = vista.getCbMarca().getSelectedIndex();
            int indiceTipo = vista.getCbTipo().getSelectedIndex();

            if (indiceMarca < 0 || indiceMarca >= marcasDisponibles.size()) {
                mostrarMensaje("Seleccione una marca válida.");
                return;
            }

            if (indiceTipo < 0 || indiceTipo >= tiposDisponibles.size()) {
                mostrarMensaje("Seleccione un tipo de producto válido.");
                return;
            }

            String pesoTexto = vista.getTxtPeso().getText().trim();
            String precioTexto = vista.getTxtPrecio().getText().trim();

            if (pesoTexto.isEmpty() || precioTexto.isEmpty()) {
                mostrarMensaje("Peso y precio son obligatorios.");
                return;
            }

            double peso = Double.parseDouble(pesoTexto);
            double precio = Double.parseDouble(precioTexto);

            if (peso <= 0 || precio <= 0) {
                mostrarMensaje("Peso y precio deben ser mayores que cero.");
                return;
            }

            String imei = vista.getTxtImei().getText().trim();
            Marca marcaSeleccionada = marcasDisponibles.get(indiceMarca);
            TipoProducto tipoSeleccionado = tiposDisponibles.get(indiceTipo);

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setMarca(marcaSeleccionada);
            producto.setTipo(tipoSeleccionado);
            producto.setPeso(peso);
            producto.setPrecio(precio);
            producto.setImei(imei.isEmpty() ? null : imei);
            producto.setFragil(!imei.isEmpty());
            producto.insertarProducto();

            mostrarMensaje("Producto ingresado correctamente.");
            limpiarFormularioProducto();
            cargarCatalogosProducto();
            cargarProductosConStock();
        } catch (NumberFormatException ex) {
            mostrarMensaje("Peso y precio deben ser números válidos.");
        } catch (Exception ex) {
            mostrarMensaje("Error al ingresar producto: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnInsertarEnFactura()) {
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
            return;
        }

        if (source == vista.getBtnComprar()) {
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
            return;
        }

        if (source == vista.getBtnIngresarProducto()) {
            insertarNuevoProducto();
        }
    }
}
