package modelo;

public class Producto {

    private int id;
    private String nombre;
    private int idMarca;
    private double precio;
    private double peso;
    private String imei;
    private int idTipo;
    private boolean fragil;

    // Constructor por defecto
    public Producto() {
        this.id = 0;
        this.nombre = "";
        this.idMarca = 0;
        this.precio = 0.0;
        this.peso = 0.0;
        this.imei = "";
        this.idTipo = 0;
        this.fragil = false;
    }

    // Constructor con parámetros
    public Producto(int id, String nombre, int idMarca, double precio, double peso, 
                    String imei, int idTipo, boolean fragil) {
        this.id = id;
        this.nombre = nombre;
        this.idMarca = idMarca;
        this.precio = precio;
        this.peso = peso;
        this.imei = imei;
        this.idTipo = idTipo;
        this.fragil = fragil;
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

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }
}
