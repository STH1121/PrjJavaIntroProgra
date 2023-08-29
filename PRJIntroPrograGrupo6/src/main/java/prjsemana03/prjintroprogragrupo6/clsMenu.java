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
     int posInventario=0;
    
    
    public void menuprincipal(){
    clsHelper clsH = new clsHelper();
        clsProducto inventario[]= new clsProducto[0];
        
        
        
        
        
        char usuario = ' ';
        
        do {
            usuario = clsH.recibeChar("Seleccione una opción:"
                    + "\nA. Modulo Ventas"
                    + "\nB. Modulo Compras"
                    + "\nC. Modulo Usuarios"
                    + "\nD. Modulo Inventario"
                    + "\nE. Modulo Administracion"
                    + "\nF. Seguridad del sistema"
                    + "\nS. Salir");
            
        switch (usuario) {
                case 'A':
                    clsH.imprimeMensaje( "Iniciando modulo de ventas");
                    inventario = this.moduloVentas(inventario,posInventario);
                    break;
                case 'B':
                    clsH.imprimeMensaje( "Iniciando modulo de compras");
                    inventario = this.moduloCompra(inventario,posInventario);
                    break;
                case 'C':
                    clsH.imprimeMensaje( "Iniciando modulo usuarios");
                    // this.usuarios();
                    break;
                case 'D':
                    clsH.imprimeMensaje( "Iniciando modulo inventario");
                    inventario = this.moduloInventarios(inventario);
                    break;
                case 'E':
                    clsH.imprimeMensaje( "Iniciando modulo administracion");
                    // this.administracion();
                    break;    
                case 'F':
                    clsH.imprimeMensaje( "Abriendo seguridad del sistema");
                    // this.seguridad();
                    break;    
                
                case 'S':
                    clsH.imprimeMensaje( "Cerrando aplicacion.");
                     
                    break;
                default:
                    clsH.imprimeMensaje( "Digite una opcion valida");
                    break;
            }
            
            
            
            
        } while (usuario != 'S');
        
        
        
        
    }
   
    
    public clsProducto[] moduloInventarios(clsProducto inventario[]){
        clsHelper clsH = new clsHelper();
        clsProducto clsP = new clsProducto();
        boolean listaInventario = false;
        char usuario = 'S';

        do{
            usuario = clsH.recibeChar("Seleccione una opcion:"
                    + "\nA. Generar lista"
                    + "\nB. Agregar producto a la lista"
                    + "\nC. Modificar producto"
                    + "\nD. Eliminar producto"
                    + "\nE. Buscar"
                    + "\nF. Listar productos"

                    + "\nS.Salir");

            switch(usuario){
                case'A':
                    if (listaInventario) {
                        char nueva = 'N';
                        do {
                            nueva = clsH.recibeChar("Desea generar una nuevo inventario?\nSi\nNo\n\n\nEsto Borra todo el inventario anterior");
                        } while (nueva != 'S' && nueva != 'N');
                        if (nueva == 'S') {
                            inventario = clsP.generarListaProductos();
                            posInventario = 0;
                            listaInventario = true;
                        }
                    } else {
                        inventario = clsP.generarListaProductos();
                        listaInventario = true;
                    }
                break;
                case'B':
                    if (listaInventario) {
                        if (posInventario < inventario.length) {
                            posInventario = clsP.agregarProducto(inventario, posInventario,"nuevo");
                            clsH.imprimeMensaje("Producto agregado satisfactoriamente.");
                        } else {
                            clsH.imprimeMensaje("La lista de productos se encuentra llena, ya no puede agregar más!");
                        }
                    } else {
                        clsH.imprimeMensaje("Debe generar primero la lista de Inventario!");
                    }

                break;
                case'C':
                    if (posInventario == 0) {
                        clsH.imprimeMensaje("Debe agregar un Producto primero!");
                    } else {
                        clsP.modificarProducto(inventario, posInventario);
                    }

                break;
                case'D':
                    if (posInventario == 0) {
                        clsH.imprimeMensaje("Debe agregar un Producto primero!");
                    } else {
                        posInventario = clsP.eliminarProducto(inventario, posInventario);
                    }

                break;
                case'E':
                     if (posInventario == 0) {
                        clsH.imprimeMensaje("Debe agregar un Producto primero!");
                    } else {
                        clsP.buscarProducto(inventario, posInventario);
                    }
                break;
                case'F':
                   if (posInventario == 0) {
                        clsH.imprimeMensaje("Debe agregar un Producto primero!");
                    } else {
                        clsP.listarProductos(inventario, posInventario);
                    } 
                break;
                case 'S':
                    clsH.imprimeMensaje( "Cerrando Modulo.");

                break;
                default:
                    clsH.imprimeMensaje( "Digite una opcion valida");
                break;

            }
        }while(usuario !='S');
        
        return inventario;
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
        char usuario = 'S';
        int posVenta = 0;
        clsProducto[] venta = new clsProducto[100];
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
                int poscProductoBuscado = -1;
                
                char opcion = 'N';
                do {
                    
                    posVenta = clsP.agregarProductoCompra(venta, posVenta,"Vender");

                    String nombreBuscar = venta[posVenta-1].getNombre();
                    
                    
                    poscProductoBuscado = clsP.obtenerPoscProductosCompra(venta, posVenta, nombreBuscar);
                    

                    if (poscProductoBuscado == -1) {
                        clsH.imprimeMensaje("el producto no esta en el inventario");
                    }else{
                    
                    venta[posVenta-1].setPrecio(inventario[poscProductoBuscado].getPrecio());
                    
                    
                    }
            
            
            
                        
                    opcion = clsH.recibeChar("Desea agregar mas producto? S/N");

                    } while (opcion != 'N');
                
                    for (int i = 0; i < posVenta; i++) {
                        factura += venta[i].toString()+"\n";
                    }
                    for (int i = 0; i < posVenta; i++) {
                        cantidadTotal+= venta[i].getCantidad() * venta[i].getPrecio();
                    }
                    factura += "\n\t\t"+cantidadTotal+"₡\n"; //2% iva
                    iva = cantidadTotal /5;
                    iva +=cantidadTotal;
                    factura += "\t\t"+iva+"₡ IVA\n";
                    
                    clsI.guardarInforme(factura);
                    
                    
                    for (int i = 0; i < posVenta; i++) {
                        
                        for (int j = 0; j < posInventario; j++) {
                            
                            if (venta[i].getNombre().equalsIgnoreCase(inventario[j].getNombre())) {
                                if (venta[i].getCantidad() < inventario[j].getCantidad()+1) {
                                    inventario[j].setCantidad(inventario[j].getCantidad()-venta[i].getCantidad());
                                }else{
                                    clsH.imprimeMensaje("No hay suficente "+venta[i].getNombre()+" para realizar la venta");
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
