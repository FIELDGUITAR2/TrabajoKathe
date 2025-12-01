package modelo;

import conexion.ConexionBD;
import conexion.MarcaDAO;
import conexion.ProductoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fieldguitar
 */
public class Marca {
    
    private int idMarca;
    private String nombreMarca;

    // Constructor por defecto
    public Marca() {
        this.idMarca = 0;
        this.nombreMarca = "";
    }

    // Constructor con parámetros
    public Marca(int idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    // Getters y Setters
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    // Método toString opcional para imprimir fácilmente la información
    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + ", nombreMarca='" + nombreMarca + '\'' + '}';
    }
    
    public List<Marca> consultarListaMarcas()
    {
        ConexionBD conexion = new ConexionBD();
        MarcaDAO marcaDAO = new MarcaDAO();
        List<Marca> listaMarca = new ArrayList<>();
        try {
            conexion.abrir();
            ResultSet rs = conexion.ejecutarTF(marcaDAO.consultarListaMarcas());

            while (rs.next()) {
                Marca marca = new Marca(
                        rs.getInt("idMarca"),
                        rs.getString("nombreMarca")
                );
                listaMarca.add(marca);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return listaMarca;
    }
}
