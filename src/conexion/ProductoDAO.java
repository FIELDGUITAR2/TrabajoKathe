package conexion;


public class ProductoDAO {

    private int id;
    private String nombre;
    private MarcaDAO marca;
    private double precio;
    private double peso;
    private String imei;
    private TipoProductoDAO tipo;
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
    public ProductoDAO(int id, String nombre, MarcaDAO marca, double precio, double peso,
                    String imei, TipoProductoDAO tipo, boolean fragil) {
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

    public MarcaDAO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDAO marca) {
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

    public TipoProductoDAO getTipo() {
        return tipo;
    }

    public void setTipo(TipoProductoDAO tipo) {
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
        "('"+this.nombre+"',"+this.precio+","+this.peso+","+this.tipo.getIdTipoProducto()+","+this.marca.getNombreMarca()+");";
        
    }
}
