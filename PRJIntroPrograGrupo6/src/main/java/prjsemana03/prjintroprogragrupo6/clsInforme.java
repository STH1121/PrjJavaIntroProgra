/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjsemana03.prjintroprogragrupo6;
import java.awt.TextArea;
/**
 *
 * @author Steven
 */
public class clsInforme {
    private String informe;  
    private String informePasado;
    private String informeCompra;  
    private String informePasadoCompra = "Producto\tCantidad";
    public clsInforme() {
    }

    public clsInforme(String informe, String informePasado) {
        this.informe = informe;
        this.informePasado = informePasado;
    }

    public clsInforme(String informe, String informePasado, String informeCompra, String informePasadoCompra) {
        this.informe = informe;
        this.informePasado = informePasado;
        this.informeCompra = informeCompra;
        this.informePasadoCompra = informePasadoCompra;
    }
    
    

    public String getInformePasado() {
        return informePasado;
    }

    public void setInformePasado(String informePasado) {
        this.informePasado = informePasado;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }
    
        public String getInformeCompra() {
        return informeCompra;
    }

    public void setInformeCompra(String informeCompra) {
        this.informeCompra = informeCompra;
    }

    public String getInformePasadoCompra() {
        return informePasadoCompra;
    }

    public void setInformePasadoCompra(String informePasadoCompra) {
        this.informePasadoCompra = informePasadoCompra;
    }
    
    @Override
    public String toString() {
        return informePasado;
    }
   
    public void guardarInforme(String informeRecibe){
        this.informeTotal(informeRecibe);
        informe = informeRecibe;
    }
    
    public void informeTotal(String informeRecibe){
        informePasado += "------------------------------------------------------------------------\n";
        informePasado += informeRecibe;        
    }
    
    public void imprimeInforme(){
        clsHelper clsH = new clsHelper();
        clsH.imprimeMensaje(new TextArea(informe));
    }
    public void imprimeInformeTotal(){
        clsHelper clsH = new clsHelper();
        clsH.imprimeMensaje(new TextArea(informePasado));
    }

    public void guardarInformeCompra(String informeRecibe){
        this.informeTotalCompra(informeRecibe);
        informeCompra = informeRecibe;
    }
    
    public void informeTotalCompra(String informeRecibe){
        
        informePasadoCompra += informeRecibe;
        informePasadoCompra += "------------------------------------------------------------------------\n";
        
    }
    
    public void imprimeInformeCompra(){
        clsHelper clsH = new clsHelper();
        clsH.imprimeMensaje(new TextArea(informeCompra));
    }
    public void imprimeInformeTotalCompra(){
        clsHelper clsH = new clsHelper();
        clsH.imprimeMensaje(new TextArea(informePasadoCompra));
    }
    
    
}
