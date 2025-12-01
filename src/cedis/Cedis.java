/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cedis;

import vista.Formulario;
import control.Control;
import java.awt.EventQueue;

/**
 *
 * @author katik
 */
public class Cedis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Formulario vista = new Formulario();
            Control controlador = new Control(vista);
            vista.setVisible(true);
        });
    }
    
}
