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

    
    public clsProducto[] moduloCompra(clsProducto inventario[], int posInventario){
        clsHelper clsH = new clsHelper();
        clsProducto clsP = new clsProducto();
        char usuario = ' ';
        do {
             usuario = clsH.recibeChar("Seleccione una opción:"
                    + "\nA. Compra nueva"
                    + "\nB. "
                    + "\nC. "
                    
                    + "\nS. Salir");
            switch(usuario){
                case 'A':
                    String productoAgregar= clsH.recibirString("Digite el nombre del producto a agregar:");
                    int posProductoAgregar= -1;
                    int cantidadAgregar =0;
                    for (int i = 0; i < posInventario; i++) {
                        if ( productoAgregar.equalsIgnoreCase(inventario[i].getNombre())) {
                            posProductoAgregar = i;
                        }
                    }
                    if (posProductoAgregar == -1) {
                        clsH.imprimeMensaje("El producto no existe,\ntiene que agregarlo desde el modulo de inventario");
                    }else{
                        cantidadAgregar = clsH.recibeInt("Indique la cantidad de producto a agregar:");
                        inventario[posProductoAgregar].setCantidad(inventario[posProductoAgregar].getCantidad()+cantidadAgregar);
                    }
                    
                
                
                    break;
                    
                 
                    case 'S':
                    clsH.imprimeMensaje( "Cerrando Modulo.");
                     
                    break;
                default:
                    clsH.imprimeMensaje( "Digite una opcion valida");
                    break;
                    
                    
            }
            
        } while (usuario !='S');
        
        
        return inventario;
    }
    
    
    
    public clsProducto[] moduloVentas(clsProducto inventario[],int posInventario){
        clsHelper clsH = new clsHelper();
        clsProducto clsP = new clsProducto();
        clsInforme clsI = new clsInforme();
        char usuario = ' ';
        
        do {
            usuario = clsH.recibeChar("Seleccione una opción:"
                    + "\nA. Factura nueva"
                    + "\nB. Revisar factura anterior"
                    + "\nC. Todas las Facturas"
                    
                    + "\nS. Salir");
            switch (usuario){
                case 'A':
                String factura = "Nombre\tCantidad\tPrecio\n";
                int cantidadTotal= 0;
                int iva = 0;
                clsProducto compra[] = clsP.generarListaProductos();
                int posVenta = 0;
                char opcion = ' ';
                do {
                    posVenta = clsP.agregarProductoCompra(compra, posVenta,"Vender");

                    String nombreBuscar = compra[posVenta].getNombre();
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
                    
                    compra[posVenta].setPrecio(inventario[poscProductoBuscado].getPrecio());
                    posVenta++;
                    
                    }
            
            
            
                        
                    opcion = clsH.recibeChar("Desea agregar mas producto? S/N");

                    } while (opcion == 'N');
                    for (int i = 0; i < posVenta; i++) {
                        factura += compra[i].toString()+"\n";
                    }
                    for (int i = 0; i < posVenta; i++) {
                        cantidadTotal+= compra[i].getCantidad() * compra[i].getPrecio();
                    }
                    factura += "\n\t\t"+cantidadTotal+"₡\n";
                    iva = cantidadTotal /5;
                    iva +=cantidadTotal;
                    factura += "\t\t"+iva+"₡\n";
                    
                    clsI.guardarInforme(factura);
                    
                    
                    for (int i = 0; i < posVenta; i++) {
                        
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
                 clsI.imprimeInforme();
                break; 
                case 'C':
                 clsI.imprimeInformeTotal();
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
