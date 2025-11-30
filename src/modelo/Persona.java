package modelo;

/**
 *
 * @author fieldguitar
 */
public abstract class Persona {
    
    protected int id;
    protected String nombre;

    // Constructor por defecto
    public Persona() {
        this.id = 0;
        this.nombre = "";
    }

    // Constructor con parámetros
    public Persona(int id, String nombre) {
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
