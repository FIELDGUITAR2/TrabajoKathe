package modelo;

/**
 *
 * @author fieldguitar
 */
public class TipoAlmacen {
    
    private int idTipo;
    private String nombreAlmacen;

    // Constructor por defecto
    public TipoAlmacen() {
        this.idTipo = 0;
        this.nombreAlmacen = "";
    }

    // Constructor con parámetros
    public TipoAlmacen(int idTipo, String nombreAlmacen) {
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
