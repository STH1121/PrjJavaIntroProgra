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
        clsHelper clasH = new clsHelper();
        
        char usuario = ' ';
        
        do {
            usuario = clasH.recibeChar("Seleccione una opción:"
                    + "\nA. Modulo Ventas"
                    + "\nB. Modulo Compras"
                    + "\nC. Modulo usuarios"
                    + "\nD. Modulo Inventario"
                    + "\nE. Modulo Administracion"
                    + "\nF. Seguridad del sistema"
                    + "\nS. Salir");
            
        switch (usuario) {
                case 'A':
                    clasH.imprimeMensaje( "Iniciando modulo de ventas");
                    // this.ventas();
                    break;
                case 'B':
                    clasH.imprimeMensaje( "Iniciando modulo de compras");
                    // this.compras();
                    break;
                case 'C':
                    clasH.imprimeMensaje( "Iniciando modulo usuarios");
                    // this.usuarios();
                    break;
                case 'D':
                    clasH.imprimeMensaje( "Iniciando modulo inventario");
                    // this.inventario();
                    break;
                case 'E':
                    clasH.imprimeMensaje( "Iniciando modulo administracion");
                    // this.administracion();
                    break;    
                case 'F':
                    clasH.imprimeMensaje( "Abriendo seguridad del sistema");
                    // this.seguridad();
                    break;    
                
                case 'S':
                    clasH.imprimeMensaje( "Cerrando aplicacion.");
                     
                    break;
                default:
                    clasH.imprimeMensaje( "Digite una opcion valida");
                    break;
            }
            
            
            
            
        } while (usuario != 'S');
    }
}
