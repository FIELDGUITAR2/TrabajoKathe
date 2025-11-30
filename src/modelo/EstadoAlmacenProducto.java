package modelo;

/**
 *
 * @author fieldguitar
 */
public class EstadoAlmacenProducto {
    
    private int idEstadoAlmPro;
    private String nombreEstadoProducto;

    // Constructor por defecto
    public EstadoAlmacenProducto() {
        this.idEstadoAlmPro = 0;
        this.nombreEstadoProducto = "";
    }

    // Constructor con parámetros
    public EstadoAlmacenProducto(int idEstadoAlmPro, String nombreEstadoProducto) {
        this.idEstadoAlmPro = idEstadoAlmPro;
        this.nombreEstadoProducto = nombreEstadoProducto;
    }

    // Getters y Setters
    public int getIdEstadoAlmPro() {
        return idEstadoAlmPro;
    }

    public void setIdEstadoAlmPro(int idEstadoAlmPro) {
        this.idEstadoAlmPro = idEstadoAlmPro;
    }

    public String getNombreEstadoProducto() {
        return nombreEstadoProducto;
    }

    public void setNombreEstadoProducto(String nombreEstadoProducto) {
        this.nombreEstadoProducto = nombreEstadoProducto;
    }

    // Método toString para depuración y visualización
    @Override
    public String toString() {
        return "EstadoAlmacenProducto{" +
                "idEstadoAlmPro=" + idEstadoAlmPro +
                ", nombreEstadoProducto='" + nombreEstadoProducto + '\'' +
                '}';
    }
}
