package modelo;

import conexion.ConexionBD;
import conexion.ProductoDAO;
import conexion.TipoProductoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fieldguitar
 */
public class TipoProducto {
    
    private int idTipoProducto;
    private String nombreTipoProducto;

    // Constructor por defecto
    public TipoProducto() {
        this.idTipoProducto = 0;
        this.nombreTipoProducto = "";
    }

    // Constructor con parámetros
    public TipoProducto(int idTipoProducto, String nombreTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        this.nombreTipoProducto = nombreTipoProducto;
    }

    // Getters y Setters
    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }

    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }

    // Método toString opcional para imprimir fácilmente la información
    @Override
    public String toString() {
        return "TipoProducto{" + "idTipoProducto=" + idTipoProducto + 
               ", nombreTipoProducto='" + nombreTipoProducto + '\'' + '}';
    }
    
    public List<TipoProducto> mostrarTiposProductos()
    {
        List<TipoProducto> tProductos = new ArrayList<>();
        ConexionBD conexion = new ConexionBD();
        TipoProductoDAO tProductoDAO = new TipoProductoDAO();

        try {
            conexion.abrir();
            ResultSet rs = conexion.ejecutarTF(tProductoDAO.mostrarTiposProductos());

            while (rs.next()) {
                TipoProducto tProducto = new TipoProducto(
                        rs.getInt("idTipoProducto"),
                        rs.getString("nombreTipoProducto")
                );

                tProductos.add(tProducto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return tProductos;
    }
}
