package modelo;

import conexion.ProductoDAO;
import conexion.ConexionBD;

public class Producto {

    private int id;
    private String nombre;
    private Marca marca;
    private double precio;
    private double peso;
    private String imei;
    private TipoProducto tipo;
    private boolean fragil;

    // Constructor por defecto
    public Producto() {
        this.id = 0;
        this.nombre = "";
        this.marca = null;       // mejor null que un número
        this.precio = 0.0;
        this.peso = 0.0;
        this.imei = "";
        this.tipo = null;        // idem
        this.fragil = false;
    }

    // Constructor con parámetros
    public Producto(int id, String nombre, Marca marca, double precio, double peso,
                    String imei, TipoProducto tipo, boolean fragil) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.peso = peso;
        this.imei = imei;
        this.tipo = tipo;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
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

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }
    
    public boolean insertarProducto()
    {
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO(this.id,this.nombre,this.marca,this.precio,this.peso,this.imei,this.tipo,this.fragil);
        conexion.abrir();
        conexion.ejecutarTF(productoDAO.insertarProducto());
        
        return false;
    }
}
