package modelo;

/**
 *
 * @author fieldguitar
 */
public class Proveedor extends Persona {
    
    private String correo;
    private String direccion;
    private String telefono;

    // Constructor por defecto
    public Proveedor() {
        super(); // llama al constructor por defecto de Persona
        this.correo = "";
        this.direccion = "";
        this.telefono = "";
    }

    // Constructor con parámetros
    public Proveedor(int id, String nombre, String correo, String direccion, String telefono) {
        super(id, nombre); // inicializa los atributos heredados de Persona
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
