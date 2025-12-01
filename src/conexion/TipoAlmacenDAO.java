package conexion;


/**
 *
 * @author fieldguitar
 */
public class TipoAlmacenDAO {
    
    private int idTipo;
    private String nombreAlmacen;

    // Constructor por defecto
    public TipoAlmacenDAO() {
        this.idTipo = 0;
        this.nombreAlmacen = "";
    }

    // Constructor con parámetros
    public TipoAlmacenDAO(int idTipo, String nombreAlmacen) {
        this.idTipo = idTipo;
        this.nombreAlmacen = nombreAlmacen;
    }

    // Getters y Setters
    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    // Método toString opcional para imprimir fácilmente la información
    @Override
    public String toString() {
        return "TipoAlmacen{" + "idTipo=" + idTipo + 
               ", nombreAlmacen='" + nombreAlmacen + '\'' + '}';
    }
}
