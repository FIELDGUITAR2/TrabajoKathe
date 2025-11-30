package modelo;

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
}
