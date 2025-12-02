// 100% EDITADO - COMBOS CON OBJETOS

package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

// IMPORTANTE: asegúrate de cambiar estos imports según tus paquetes reales:
import modelo.Marca;
import modelo.TipoProducto;
import modelo.Producto;

public class Formulario extends javax.swing.JFrame {

    public Formulario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        bntLeer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        // 🔥 COMBOS DE VENTA — Producto
        cbSeleccionarPr = new javax.swing.JComboBox<>();

        jLabel7 = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnInsertarEnFactura = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();

        // 🔥 COMBO Marca — OBJETO Marca
        cbMarca = new javax.swing.JComboBox<>();

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        // 🔥 COMBO Tipo — OBJETO TipoProducto
        cbTipo = new javax.swing.JComboBox<>();

        txtPeso = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtImei = new javax.swing.JTextField();
        btnIngresarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID producto", "Nombre", "Marca", "Tipo", "Precio"}
        ));
        jScrollPane2.setViewportView(jTable2);

        btnActualizar.setText("Actualizar");
        bntLeer.setText("Leer");
        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEliminar, 148, 148, 148)
                        .addGap(18, 18, 18)
                        .addComponent(bntLeer, 132, 132, 132)
                        .addGap(29, 29, 29)
                        .addComponent(btnActualizar, 154, 154, 154)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, 240, 240, 240)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, 41, 41, 41)
                    .addComponent(bntLeer, 41, 41, 41)
                    .addComponent(btnActualizar, 41, 41, 41))
                .addContainerGap(34, Short.MAX_VALUE)));

        jTabbedPane1.addTab("Productos", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID Producto", "Nombre", "Cantidad", "Precio U", "Total"}
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Seleccionar producto");
        btnComprar.setText("Comprar");

        jLabel8.setText("Cantidad");
        btnInsertarEnFactura.setText("Insertar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, 517, 517, 517)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSeleccionarPr, 0, 250, Short.MAX_VALUE)
                            .addComponent(txtCantidad))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnComprar, 100, 100, 100)
                            .addComponent(btnInsertarEnFactura, 100, 100, 100))))
                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, 230, 230, 230)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSeleccionarPr)
                    .addComponent(jLabel7)
                    .addComponent(btnComprar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad)
                    .addComponent(jLabel8)
                    .addComponent(btnInsertarEnFactura))
                .addContainerGap()));

        jTabbedPane1.addTab("Venta", jPanel3);

        jLabel1.setText("Ingresar nuevo producto:");
        jLabel2.setText("Marca:");
        jLabel3.setText("Tipo:");
        jLabel4.setText("Peso:");
        jLabel5.setText("Precio:");
        jLabel6.setText("IMEI:");

        btnIngresarProducto.setText("Ingresar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    )
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreProducto)
                    .addComponent(cbMarca, 0, 350, Short.MAX_VALUE)
                    .addComponent(cbTipo, 0, 350, Short.MAX_VALUE)
                    .addComponent(txtPeso)
                    .addComponent(txtPrecio)
                    .addComponent(txtImei))
                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMarca)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeso)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImei)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addComponent(btnIngresarProducto, 50, 50, 50)
                .addContainerGap()));

        jTabbedPane1.addTab("Ingresar Producto", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1));

        pack();
    }

    // ---------- GETTERS EDITADOS (OBJETOS) ------------

    public JComboBox<Marca> getCbMarca() { return cbMarca; }
    public JComboBox<TipoProducto> getCbTipo() { return cbTipo; }
    public JComboBox<Producto> getCbSeleccionarPr() { return cbSeleccionarPr; }

    public JButton getBtnIngresarProducto() { return btnIngresarProducto; }
    public JButton getBtnInsertarEnFactura() { return btnInsertarEnFactura; }
    public JButton getBtnComprar() { return btnComprar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBntLeer() { return bntLeer; }

    public JTextField getTxtPrecio() { return txtPrecio; }
    public JTextField getTxtPeso() { return txtPeso; }
    public JTextField getTxtNombreProducto() { return txtNombreProducto; }
    public JTextField getTxtImei() { return txtImei; }
    public JTextField getTxtCantidad() { return txtCantidad; }

    public JTable getTablaProductos() { return jTable2; }
    public JTable getTablaFactura() { return jTable1; }

    // ---------- VARIABLES EDITADAS ----------
    private javax.swing.JButton bntLeer;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresarProducto;
    private javax.swing.JButton btnInsertarEnFactura;

    private javax.swing.JComboBox<Marca> cbMarca;
    private javax.swing.JComboBox<TipoProducto> cbTipo;
    private javax.swing.JComboBox<Producto> cbSeleccionarPr;

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;

    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;

    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;

    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtImei;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPrecio;

}
