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
public class clsProducto {
    String nombre;
    String descripcion;
    char caja;  // SON PASTILLAS S/N
    int tamacaja;  // CUANTAS POR TABLETA
    int cantidad; // TOTAL de cantidad  
    int precio; //Precio individual si son pastillas  S/N
    char psicodelico;  // SI OCUPA PERMISO DE ADMINISTRADOR PARA VENDERLO

    public clsProducto() {
    }

    public clsProducto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        
    }
    
    
    
    public clsProducto(String nombre, String descripcion, char caja, int tamacaja, int cantidad, int precio, char psicodelico) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caja = caja;
        this.tamacaja = tamacaja;
        this.cantidad = cantidad;
        this.precio = precio;
        this.psicodelico = psicodelico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getCaja() {
        return caja;
    }

    public void setCaja(char caja) {
        this.caja = caja;
    }

    public int getTamacaja() {
        return tamacaja;
    }

    public void setTamacaja(int tamacaja) {
        this.tamacaja = tamacaja;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public char getPsicodelico() {
        return psicodelico;
    }

    public void setPsicodelico(char psicodelico) {
        clsHelper clsH = new clsHelper();
        if (psicodelico == 'S' || psicodelico == 'N' ) {
            this.psicodelico = psicodelico;
        }else {
            clsH.imprimeMensaje("Dato invalido");
        }
            
    }
    @Override
    public String toString() {
        return nombre + "\t" + cantidad + "\t" + precio;
    }
    
    public clsProducto[] generarListaProductos(){    
        clsProducto productos[] = new clsProducto[100];
        return productos;
    }
    
    public int agregarProducto(clsProducto producto[], int posProducto, String accion){
        clsHelper clsH = new clsHelper();
        String nombre = clsH.recibirString("Nombre del producto "+accion+":");
        String descripcion = clsH.recibirString("Descripcion del producto:");
        char caja;
        int tamacaja;
        char psicodelico;
        do {
             caja = clsH.recibeChar("El producto viene en tableta? S/N");
        } while (caja != 'S' && caja != 'N');
        if ( caja == 'S') {
             tamacaja = clsH.recibeInt("De que tamaño es la tableta:");
        }else{
             tamacaja = 1;
        }
        int cantidad = clsH.recibeInt("Digite la cantidad del producto");
        int precio = clsH.recibeInt("Cual es el precio del producto?");
        do {
             psicodelico = clsH.recibeChar("El producto es psicodelico? S/N");
        } while (psicodelico != 'S' && psicodelico != 'N');
        
        producto[posProducto] = new clsProducto(nombre,descripcion,caja,tamacaja,cantidad,precio,psicodelico);
        
        posProducto++;
        return posProducto;
    }

    public int agregarProductoVenta(clsProducto producto[], int posProducto,String accion){
        clsHelper clsH = new clsHelper();
        
        String nombre = clsH.recibirString("Nombre del producto "+accion+":");
        
        
        int cantidad = clsH.recibeInt("Digite la cantidad del producto");
        
        
        producto[posProducto] = new clsProducto(nombre,"",'N',0,cantidad,0,'N');
        
        posProducto++;
        return posProducto;
    }

    
    
    
    
    
    
    public int obtenerPoscProductos(clsProducto producto[], int poscProductos, String accion){
        clsHelper clsH = new clsHelper();
        String nombreBuscar = clsH.recibirString("Digite el nombre del Producto que desea "+accion+":");
        int poscProductoBuscado = -1;
        for (int i = 0; i < poscProductos; i++) {
            if (nombreBuscar.equalsIgnoreCase(producto[i].getNombre())) {
                poscProductoBuscado = i;
                break;
            }
        }
        return poscProductoBuscado;
    }    
   
        public int obtenerPoscProductosVenta(clsProducto producto[], int poscProductos, String buscado){
        
        int poscProductoBuscado = -1;
        for (int i = 0; i < poscProductos; i++) {
            if (buscado.equalsIgnoreCase(producto[i].getNombre())) {
                poscProductoBuscado = i;
                break;
            }
        }
        return poscProductoBuscado;
    }    
    
    public void modificarProducto(clsProducto[] producto, int posProducto){
        clsHelper clsH = new clsHelper();
        char tableta;
        char psicodelico;
        int posc = this.obtenerPoscProductos(producto, posProducto, "modificar");
        if (posc == -1) {
            clsH.imprimeMensaje("No se encontraron coincidencias con el nombre indicado.");
        }else{
            char opcion ='S';
            do {
                opcion = clsH.recibeChar("Seleccione el dato que desea modificar:"
                        + "\n A. Nombre Producto"
                        + "\n B. Descripcion"
                        + "\n C. Caja"
                        + "\n D. Tamaño caja"
                        + "\n E. Cantidad producto"
                        + "\n F. Precio del producto"
                        + "\n G. Psicodelico"
                        + "\n S. Salir");
                switch(opcion){
                    case 'A':
                        producto[posc].setNombre(clsH.recibirString("Digite el nuevo nombre del producto:"));
                        break;
                    case 'B':
                        producto[posc].setDescripcion(clsH.recibirString("Digite la nuevo descripcion del producto:"));
                        break;
                    case 'C':
                        do {
                        tableta = clsH.recibeChar("El producto viene en tabletas? S/N");
                            } while (tableta != 'S' && tableta != 'N');
        
                        producto[posc].setCaja(tableta);
                        break;
                    case 'D':
                        producto[posc].setTamacaja(clsH.recibeInt("Digite el tamaño de las tabletas:"));
                        break;
                    case 'E':
                        producto[posc].setCantidad(clsH.recibeInt("Digite la nueva cantidad de producto, si es pastillas en cantidad total de pastillas"));
                        break;
                    case 'F':
                        producto[posc].setPrecio(clsH.recibeInt("Digite el nuevo precio del producto:"));
                        break;   
                    case 'G':
                        
                        do {
                         psicodelico = clsH.recibeChar("El producto requiere permiso de un administrador? S/N");
                            } while (psicodelico != 'S' && psicodelico != 'N');
        
                        producto[posc].setPsicodelico(psicodelico);
                        break;   
                    case 'S':
                        clsH.imprimeMensaje("Datos modificados correctamente");
                        break;
                    default:
                        clsH.imprimeMensaje("Opción seleccionada incorrecta");
                        break;
                }
                
            } while (opcion!='S');
        }
    }
    
    public int eliminarProducto(clsProducto producto[], int posProducto){
            clsHelper clsH = new clsHelper();
            int posc = this.obtenerPoscProductos(producto, posProducto, "eliminar");
            if (posc == -1) {
                clsH.imprimeMensaje("No se encontraron coincidencias con el nombre digitado");
            }else{
                for (int i = posc; i < posProducto-1; i++) {
                    producto[i] = producto[i+1];
                }
                
                producto[posProducto]= null;
                posProducto--;

                clsH.imprimeMensaje("El Producto se eliminó de forma correcta");
            }
            return posProducto;
        }    

    public void buscarProducto(clsProducto producto[], int poscProducto){
        clsHelper clsH = new clsHelper();
        int posc = this.obtenerPoscProductos(producto, poscProducto, "buscar");
        if (posc==-1) {
            clsH.imprimeMensaje("No se encontraron coincidencia con el producto digitado");
        }
        else{
            clsH.imprimeMensaje("Los datos del Producto son:\n"
                    + "Nombre: "+producto[posc].getNombre()
                    + "\nDescripcion: "+producto[posc].getDescripcion()
                    + "\nCantidad: "+producto[posc].getCantidad()
                    + "\nPrecio: "+producto[posc].getPrecio()
                    + "\nOcupa permiso de administrador? "+producto[posc].getPsicodelico()
            );
        }
    }

    public void listarProductos(clsProducto[] producto, int poscCliente){
        clsHelper clsH = new clsHelper();
        String impresion = "Nombre\t\tCantidad precio\n"; 
        for (int i = 0; i < poscCliente; i++) {
            impresion += producto[i].toString()+"\n";
        }
        clsH.imprimeMensaje(new TextArea(impresion));
    }
    
    
    
    
    
 
}
