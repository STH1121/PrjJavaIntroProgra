/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjsemana03.prjintroprogragrupo6;

/**
 *
 * @author Steven
 */
public class clsUsuario {
    private String usuario;
    private String contra;
    private char tipoU;
    int cantidadUsuario = 0;
    clsUsuario usuarioLista[]= new clsUsuario[100];
    
    
    public clsUsuario() {
    }

    public clsUsuario(String usuario, String contra, char tipoU) {
        this.usuario = usuario;
        this.contra = contra;
        this.tipoU = tipoU;
    }

    public char getTipoU() {
        return tipoU;
    }

    public void setTipoU(char tipoU) {
        this.tipoU = tipoU;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
    private int agregarAdmin(clsUsuario usuarioLista[], int cantidadUsuario){
        
        usuarioLista[cantidadUsuario]=new clsUsuario("admin","admin",'A');
        cantidadUsuario++;
        return cantidadUsuario;
    }
    public void initUsuarios(){
        cantidadUsuario = this.agregarAdmin(usuarioLista, cantidadUsuario);
    }
    public void agregarUsuario(clsUsuario usuarioLista[]){
        clsHelper clsH = new clsHelper();
        String usuario = clsH.recibirString("Usuario:");
        String contrase = clsH.recibirString("Contraseña:");
        char tipo;
        do {
            tipo = clsH.recibeChar("Ingrese el tipo de Usuario: "
                    + "\nA = Administrador"
                    + "\nU = Cajero");
            
        } while (tipo !='A' && tipo !='U');
        usuarioLista[cantidadUsuario] = new clsUsuario(usuario,contrase,tipo);
        
        cantidadUsuario++;
    }
    
    

    
    
    
}
