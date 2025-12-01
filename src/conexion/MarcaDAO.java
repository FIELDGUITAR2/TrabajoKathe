package conexion;

/**
 *
 * @author fieldguitar
 */
public class MarcaDAO {

    private int idMarca;
    private String nombreMarca;

    // Constructor por defecto
    public MarcaDAO() {
        this.idMarca = 0;
        this.nombreMarca = "";
    }

    // Constructor con parámetros
    public MarcaDAO(int idMarca, String nombreMarca) {
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

    public String consultarListaMarcas() {
        return "select\n"
                + "idMarca,\n"
                + "nombreMarca\n"
                + "from marca\n"
                + "order by nombreMarca;";
    }
}
