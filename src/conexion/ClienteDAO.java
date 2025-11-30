package conexion;

import conexion.PersonaDAO;
/**
 *
 * @author fieldguitar
 */
public class ClienteDAO extends PersonaDAO {
    
    private String correo;
    private String telefono;

    // Constructor por defecto
    public ClienteDAO() {
        super(); // llama al constructor por defecto de Persona
        this.correo = "";
        this.telefono = "";
    }

    // Constructor con parámetros
    public ClienteDAO(int id, String nombre, String correo, String telefono) {
        super(id, nombre); // inicializa los atributos heredados
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
