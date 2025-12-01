package conexion;

import modelo.Marca;
import modelo.TipoProducto;

public class ProductoDAO {

    private int id;
    private String nombre;
    private Marca marca;
    private double precio;
    private double peso;
    private String imei;
    private TipoProducto tipo;
    private boolean fragil;

    // Constructor por defecto
    public ProductoDAO() {
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
    public ProductoDAO(int id, String nombre, Marca marca, double precio, double peso,
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
    
    public String insertarProducto()
    {
        return "insert into producto(nombreProducto,precioUnidad,peso,idTipo,idMarca)\n" +
        "VALUES\n" +
        "('"+this.nombre+"',"+this.precio+","+this.peso+","+this.tipo.getIdTipoProducto()+","+this.marca.getIdMarca()+");";
        
    }
    
    public String eliminarProducto()
    {
        return "DELETE FROM producto\n" +
                "WHERE idProducto = "+this.getId()+";";
    }
    
    public String actualizarProducto()
    {
        return "UPDATE producto\n" +
"SET nombreProducto = '"+this.nombre+"',\n" +
"    idTipo = '"+this.getTipo().getIdTipoProducto()+"',\n" +
"    imei = '"+this.imei+"',\n" +
"    fragil = "+this.isFragil()+",\n" +
"    idMarca = "+this.getMarca().getIdMarca()+",\n" +
"    peso = "+this.peso+",\n" +
"    precioUnidad = "+this.precio+"\n" +
"WHERE idProducto = "+this.id+";";
    }
    
    public String mostrarProducto()
    {
        return "";
    }
    
    public String mostrarProductos()
    {
        return "";
    }
}
