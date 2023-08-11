/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjsemana03.prjintroprogragrupo6;

/**
 *
 * @author Steven
 */
public class clsProducto {
    String nombre;
    String descripcion;
    char caja;
    int tamacaja;
    int cantidad;
    int precio;
    char psicodelico;

    public clsProducto() {
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

    
    public clsProducto[] generarListaProductos(){
        clsHelper clsH = new clsHelper();
        int tamano = clsH.recibeInt("Digite el tamaño de la lista de productos");
        clsProducto productos[] = new clsProducto[tamano];
        return productos;
    }
    
    public int agregarProducto(clsProducto producto[], int posProducto){
        clsHelper clsH = new clsHelper();
        String nombre = clsH.recibirString("Nombre del producto:");
        String descripcion = clsH.recibirString("Descripcion del producto:");
        
        do {
            char caja = clsH.recibeChar("El producto viene en tableta? S/N");
        } while (caja != 'S' || caja != 'N');
        if ( caja == 'S') {
            int tamacaja = clsH.recibeInt("De que tamaño es la tableta");
        }else{
            int tamacaja = 0;
        }
        int cantidad = clsH.recibeInt("Digite la cantidad del producto");
        int precio = clsH.recibeInt("cual es el precio del producto?");
        do {
            char psicolodegico = clsH.recibeChar("El producto viene en tableta? S/N");
        } while (psicodelico != 'S' || psicodelico != 'N');
        
        producto[posProducto] = new clsProducto(nombre,descripcion,caja,tamacaja,cantidad,precio,psicodelico);
        
        posProducto++;
        return posProducto;
    }
    
    public int obtenerPoscProductos(clsProducto producto[], int poscProductos, String accion){
        clsHelper clsH = new clsHelper();
        String nombreBuscar = clsH.recibirString("Digite el nombre del cliente que desea "+accion+":");
        int poscProductoBuscado = -1;
        for (int i = 0; i < poscProductos; i++) {
            if (nombreBuscar.equalsIgnoreCase(producto[i].getNombre())) {
                poscProductoBuscado = i;
                break;
            }
        }
        return poscProductoBuscado;
    }    
    
    public void modificarCliente(clsProducto[] producto, int posProducto){
        clsHelper clsH = new clsHelper();
        int posc = this.obtenerPoscProductos(producto, posProducto, "modificar");
        if (posc == -1) {
            clsH.imprimeMensaje("No se encontraron coincidencias con el nombre indicado.");
        }else{
            char opcion ='S';
            do {
                opcion = clsH.recibeChar("Seleccione el dato que desea modificar:"
                        + "\n A. Nombre Completo"
                        + "\n B. Correo"
                        + "\n C. Telefono"
                        + "\n D. Direccion"
                        + "\n E. Edad"
                        + "\n S. Salir");
                switch(opcion){
                    case 'A':
                        producto[posc].setNombreCompleto(clsH.recibeString("Digite el nuevo nombre del cliente:"));
                        break;
                    case 'B':
                        producto[posc].setCorreo(clsH.recibeString("Digite el nuevo correo del cliente:"));
                        break;
                    case 'C':
                        producto[posc].setNumTelefono(clsH.recibeString("Digite el nuevo teléfono del cliente:"));
                        break;
                    case 'D':
                        producto[posc].setDireccion(clsH.recibeString("Digite la nueva direccion del cliente:"));
                        break;
                    case 'E':
                        producto[posc].setEdad(clsH.recibeInt("Digite la nueva edad del cliente:"));
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
    
    

    
    
}
