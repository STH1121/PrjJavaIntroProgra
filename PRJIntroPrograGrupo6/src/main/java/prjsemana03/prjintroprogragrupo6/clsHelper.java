/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjsemana03.prjintroprogragrupo6;

import javax.swing.JOptionPane;


/**
 *
 * @author Steven
 */
public class clsHelper {
    public static boolean IsInteger(String text) {
    int v;
    try {
      v=Integer.parseInt(text);
      return true;
    } catch (NumberFormatException ex) {
       return false;
    }
}
    
    public int recibeInt(String mensaje){
        do {          
                    
            mensaje = JOptionPane.showInputDialog(mensaje);
            
        } while(!IsInteger(mensaje)); 
        
        return Integer.parseInt( mensaje);     
    }
    
    public char recibeChar(String mensaje){
        return JOptionPane.showInputDialog(mensaje).toUpperCase().charAt(0);
    }
    public void imprimeMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public String recibirString(String mensaje){
            return JOptionPane.showInputDialog(mensaje);
    }
    public String convetirString(int mensaje){
            return String.valueOf(mensaje);
    }
}
