package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    private Connection conexion;
    private ResultSet resultado;
    private Statement sentencia;
    
    // Abrir conexión
    public void abrir() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Cedis_bd", "root", "123456"
            );
            sentencia = conexion.createStatement();
            System.out.println("Conexión abierta correctamente.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al abrir la conexión: " + e.getMessage());
        }
    }
    
    // Cerrar conexión
    public void cerrar() {
        try {
            if (resultado != null) resultado.close();
            if (sentencia != null) sentencia.close();
            if (conexion != null) conexion.close();
            System.out.println("Conexión cerrada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
    // Ejecutar sentencia sin retorno
    public void ejecutar(String sql) {
        try {
            sentencia.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar sentencia: " + e.getMessage());
        }
    }
    
    // Ejecutar sentencia y devolver ResultSet
    public ResultSet ejecutarTF(String sql) {
        try {
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Error al ejecutar consulta: " + e.getMessage());
        }
        return resultado;
    }
    
    // Obtener un registro (fila)
    public String[] registro() {
        try {
            if (resultado != null && resultado.next()) {
                int columnas = resultado.getMetaData().getColumnCount();
                String[] fila = new String[columnas];
                for (int i = 1; i <= columnas; i++) {
                    fila[i - 1] = resultado.getString(i);
                }
                return fila;
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener registro: " + e.getMessage());
        }
        return null;
    }
    
    // Contar filas del resultado
    public int filas() {
        try {
            if (resultado != null) {
                resultado.last(); // mover al último
                int total = resultado.getRow();
                resultado.beforeFirst(); // volver al inicio
                return total;
            }
        } catch (SQLException e) {
            System.err.println("Error al contar filas: " + e.getMessage());
        }
        return 0;
    }
}
