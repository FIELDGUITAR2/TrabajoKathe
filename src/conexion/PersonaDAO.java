package conexion;


/**
 *
 * @author fieldguitar
 */
public abstract class PersonaDAO {
    
    protected int id;
    protected String nombre;

    // Constructor por defecto
    public PersonaDAO() {
        this.id = 0;
        this.nombre = "";
    }

    // Constructor con parámetros
    public PersonaDAO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
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
