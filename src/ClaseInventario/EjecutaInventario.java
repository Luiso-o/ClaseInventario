package ClaseInventario;

public class EjecutaInventario {

	public static void main(String[] args) {
		
		// Crear algunos productos
        Producto producto1 = new Producto("Laptop", "Mac", "1234567890", 1500.0,10);
        Producto producto2 = new Producto("Teléfono", "Huawei", "0987654321", 800.0, 20);
        Producto producto3 = new Producto("Tablet", "Shaiomi", "4567890123", 400.0, 15);
        Producto producto4 = new Producto("Television", "Samsung", "9807655432", 2000.0, 25);
        Producto producto5 = new Producto("Lavadora", "LG", "4576239801", 800.0, 90);
        Producto producto6 = new Producto("Cafetera", "Nespresso", "4598877665", 150.0, 30);

        // Crear un inventario y agregar los productos
        Inventario inventario = new Inventario();
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
        inventario.agregarProducto(producto3);
        inventario.agregarProducto(producto4);
        inventario.agregarProducto(producto5);
        inventario.agregarProducto(producto6);
        
        // Realizar una venta de algunos productos
        Venta venta = new Venta();
        venta.realizarVenta(producto1,9);
        venta.realizarVenta(producto2,20);
        venta.realizarVenta(producto3,10);
        venta.realizarVenta(producto4,16);
        venta.realizarVenta(producto5,60);
        venta.realizarVenta(producto6,13);
        
       //Crea un menu 
       int indice=MetodosMenu.menu();
       
       while(indice>0 && indice<5) {
    	   switch(indice){   
	    	   case 1://crear producto
	    		   MetodosMenu.agregaNuevoProducto(inventario);  
	    		   indice=MetodosMenu.menu();
	    		   break;
	    	   case 2://hacer una venta
	    	       MetodosMenu.hacerVenta(inventario, venta);
	    	       indice=MetodosMenu.menu();
	    	       break;
	    	   case 3: //ver inventario
	    		   inventario.imprimeInventario();
	    		   indice=MetodosMenu.menu();
	    		   break;
	    	   case 4://ver vendidos
	    		    venta.imprimeVendidos(); 
	    		    indice=MetodosMenu.menu();
	    		   break;
	    		   default:
	    			   System.out.println("Opcion no encontrada");
	    			   break;
	    	   }
       }
         
        System.out.println("<<FIN DEL PROGRAMA>>");
     
	}

}
