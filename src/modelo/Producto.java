package modelo;

import modelo.TipoProducto;
import conexion.ConexionBD;
import modelo.Marca;
import conexion.ProductoDAO;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

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

    public Producto(int id, String nombre, Marca marca, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
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

    public void insertarProducto() {
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO(
                this.id, this.nombre, this.marca, this.precio, this.peso, this.imei, this.tipo, this.fragil
        );
        conexion.abrir();
        conexion.ejecutar(productoDAO.insertarProducto());
        conexion.cerrar();
    }

    public void eliminarProducto() {
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.setId(id);
        conexion.abrir();
        conexion.ejecutar(productoDAO.eliminarProducto());
        conexion.cerrar();
    }

    public void actualizarProducto() {
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO(
                this.id, this.nombre, this.marca, this.precio, this.peso, this.imei, this.tipo, this.fragil
        );
        conexion.abrir();
        conexion.ejecutar(productoDAO.actualizarProducto());
        conexion.cerrar();
    }

    public Producto mostrarProducto() {
        Producto producto = new Producto();
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO();

        try {
            conexion.abrir();
            ResultSet rs = conexion.ejecutarTF(productoDAO.mostrarListaProductos());

            while (rs.next()) {
                Marca marca = new Marca(
                        rs.getInt("idMarca"),
                        rs.getString("nombreMarca")
                );

                        producto = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("nombreProducto"),
                        marca,
                        rs.getFloat("precioUnidad")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return producto;
    }

    public List<Producto> mostrarListaProductos() {
        List<Producto> productos = new ArrayList<>();
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO();

        try {
            conexion.abrir();
            ResultSet rs = conexion.ejecutarTF(productoDAO.mostrarListaProductos());

            while (rs.next()) {
                Marca marca = new Marca(
                        rs.getInt("idMarca"),
                        rs.getString("nombreMarca")
                );

                Producto producto = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("nombreProducto"),
                        marca,
                        rs.getFloat("precioUnidad")
                );

                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return productos;
    }

    public List<Producto> obtenerProductosConStock() {
        List<Producto> productos = new ArrayList<>();
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO();

        try {
            conexion.abrir();
            ResultSet rs = conexion.ejecutarTF(productoDAO.obtenerProductosConStock());

            while (rs.next()) {
                Marca marca = new Marca(
                        rs.getInt("idMarca"),
                        rs.getString("marca")
                );

                Producto producto = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        marca,
                        rs.getDouble("precio")
                );

                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return productos;
    }

    public Producto buscarProductoPorId(int idProducto) {
        Producto producto = null;
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.setId(idProducto);

        try {
            conexion.abrir();
            ResultSet rs = conexion.ejecutarTF(productoDAO.mostrarProducto());

            if (rs.next()) {
                Marca marca = new Marca(
                        rs.getInt("idMarca"),
                        rs.getString("marca")
                );

                producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        marca,
                        rs.getDouble("precio")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrar();
        }

        return producto;
    }

    public void actualizarStock(int cantidadVendida) {
        ConexionBD conexion = new ConexionBD();
        ProductoDAO productoDAO = new ProductoDAO();
        conexion.abrir();
        conexion.ejecutar(productoDAO.actualizarStock(this.id, cantidadVendida));
        conexion.cerrar();
    }

}
