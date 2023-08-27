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
    private     String informe;
    
    private String informePasado;

    public clsInforme() {
    }

    public clsInforme(String informe, String informePasado) {
        this.informe = informe;
        this.informePasado = informePasado;
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

    @Override
    public String toString() {
        return informePasado;
    }
   
    public void guardarInforme(String informeRecibe){
        this.informeTotal(informeRecibe);
        informe = informeRecibe;
    }
    
    public void informeTotal(String informeRecibe){
        informePasado += informeRecibe;
        informePasado += "------------------------------------------------------------------------\n";
    }
    
    public void imprimeInforme(){
        clsHelper clsH = new clsHelper();
        clsH.imprimeMensaje(new TextArea(informe));
    }
    public void imprimeInformeTotal(){
        clsHelper clsH = new clsHelper();
        clsH.imprimeMensaje(new TextArea(informePasado));
    }
}
