/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjsemana03.prjintroprogragrupo6;

/**
 *
 * @author Steven
 */
public class clsMenu {
     
    
    
    public void menuprincipal(){
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
                    //this.moduloVentas(invetario[],posInventario);
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

    
    
    
    
    
    public clsProducto[] moduloVentas(clsProducto inventario[],int posInventario){
        clsHelper clsH = new clsHelper();
        clsProducto clsP = new clsProducto();
        
        char usuario = ' ';
        
        do {
            usuario = clsH.recibeChar("Seleccione una opción:"
                    + "\nA. Factura nueva"
                    + "\nB. "
                    
                    + "\nS. Salir");
            switch (usuario){
                case 'A':
                String factura = "Nombre\tCantidad\tPrecio\n";
                int cantidadTotal= 0;
                clsProducto compra[] = clsP.generarListaProductos();
                int posCompra = 0;
                char opcion = ' ';
                do {
                    posCompra = clsP.agregarProductoCompra(compra, posCompra);

                    String nombreBuscar = compra[posCompra].getNombre();
                    int poscProductoBuscado = -1;
                    for (int i = 0; i < posInventario; i++) {
                        if (nombreBuscar.equalsIgnoreCase(inventario[i].getNombre())) {
                        poscProductoBuscado = i;
                        break;
                        }
                    }
                    if (poscProductoBuscado == -1) {
                        clsH.imprimeMensaje("el producto no esta en el inventario");
                    }else{
                    
                    compra[posCompra].setPrecio(inventario[poscProductoBuscado].getPrecio());
                    posCompra++;
                    
                    }
            
            
            
                        
                    opcion = clsH.recibeChar("Desea agregar mas producto? S/N");

                    } while (opcion == 'N');
                    for (int i = 0; i < posCompra; i++) {
                        factura += compra[i].toString()+"\n";
                    }
                    for (int i = 0; i < posCompra; i++) {
                        cantidadTotal+= compra[i].getCantidad() * compra[i].getPrecio();
                    }
                    factura += "\n\t\t"+cantidadTotal+"₡";
                    
                    
                    
                    for (int i = 0; i < posCompra; i++) {
                        
                        for (int j = 0; j < posInventario; j++) {
                            
                            if (compra[i].getNombre().equalsIgnoreCase(inventario[j].getNombre())) {
                                if (compra[i].getCantidad()> inventario[j].getCantidad()) {
                                    inventario[j].setCantidad(inventario[j].getCantidad()-compra[i].getCantidad());
                                }else{
                                    clsH.imprimeMensaje("No hay suficente "+compra[i].getNombre()+" para realizar la venta");
                                    break;
                                }
                                
                                
                            }
                            
                            
                        }
                    }
                    
                    
                    
                    
                    
                    break;
                case 'B':
                 
                break; 
                case 'S':
                    clsH.imprimeMensaje( "Cerrando Modulo.");
                     
                    break;
                default:
                    clsH.imprimeMensaje( "Digite una opcion valida");
                    break;
                    }
                    


                } while (usuario != 'S');
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        return inventario;
    }
    
}
