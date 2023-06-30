/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package prjsemana03.prjintroprogragrupo6;
import javax.swing.JOptionPane;
/**
 *
 * @author Steven
 */
public class PRJIntroPrograGrupo6 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        char usuario = ' ';
        
        do {
            usuario = JOptionPane.showInputDialog("Seleccione una opción:"
                    + "\nA. Modulo Ventas"
                    + "\nB. Modulo Compras"
                    + "\nC. Modulo usuarios"
                    + "\nD. Modulo Inventario"
                    + "\nE. Modulo Administracion"
                    + "\nF. Seguridad del sistema"
                    + "\nS. Salir").toUpperCase().charAt(0);
            
        switch (usuario) {
                case 'A':
                    JOptionPane.showMessageDialog(null, "Iniciando modulo de ventas");
                    // this.ventas();
                    break;
                case 'B':
                    JOptionPane.showMessageDialog(null, "Iniciando modulo de compras");
                    // this.compras();
                    break;
                case 'C':
                    JOptionPane.showMessageDialog(null, "Iniciando modulo usuarios");
                    // this.usuarios();
                    break;
                case 'D':
                    JOptionPane.showMessageDialog(null, "Iniciando modulo inventario");
                    // this.inventario();
                    break;
                case 'E':
                    JOptionPane.showMessageDialog(null, "Iniciando modulo administracion");
                    // this.administracion();
                    break;    
                case 'F':
                    JOptionPane.showMessageDialog(null, "Abriendo seguridad del sistema");
                    // this.seguridad();
                    break;    
                
                case 'S':
                    JOptionPane.showMessageDialog(null, "Apagando aplicacion.");
                     
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite una opcion valida");
                    break;
            }
            
            
            
            
        } while (usuario != 'S');
    }
}
