package conexion;

import modelo.TipoAlmacen;
/**
 *
 * @author fieldguitar
 */
public class AlmacenDAO {

    private int idAlmacen;
    private TipoAlmacen tipoAlmacen;
    private String nombreAlmacen;

    // Constructor por defecto
    public AlmacenDAO() {
        this.idAlmacen = 0;
        this.tipoAlmacen = null; // mejor null que un número
        this.nombreAlmacen = "";
    }

    // Constructor con parámetros
    public AlmacenDAO(int idAlmacen, TipoAlmacen tipoAlmacen, String nombreAlmacen) {
        this.idAlmacen = idAlmacen;
        this.tipoAlmacen = tipoAlmacen;
        this.nombreAlmacen = nombreAlmacen;
    }

    // Getters y Setters
    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public TipoAlmacen getTipoAlmacen() {
        return tipoAlmacen;
    }

    public void setTipoAlmacen(TipoAlmacen tipoAlmacen) {
        this.tipoAlmacen = tipoAlmacen;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }
}
