package ClaseInventario;

import java.util.ArrayList;

	public class Venta {
		//atributo
	    private ArrayList<Producto>vendidos;
	    
	    //constructor
	    public Venta() {
	        this.vendidos = new ArrayList<>();
	    }
	    
	    //Metodos
	    //restamos una unidad del producto
	    public void realizarVenta(Producto producto, int unidades) {
	    	//agregamos a la lista de productos vendidos
	    	agregarProductoVendido(producto,unidades);
	    	//modificamos la cantidad en el stock
    		producto.setCantidadDisponible(producto.getCantidadDisponible()-unidades);	
		    	
	    }

	    //imprime la lista de vendidos
		public void imprimeVendidos() {
			
			System.out.println("Unidades vendidas:");
			
			 for (int i=0; i<vendidos.size(); i++) {
				 
		        	System.out.println("\t"+vendidos.get(i));
			
		     }
			 
			 ganancias();
			 System.out.println("");
		}
	   
		/*verifica si ya existe este producto en la lista de ventas,
		 * si lo encuentra devolvera el indice, de lo contrario devolvera un -1*/
	    private int verificaProducto(Producto producto) {
	    	
	    	int indice=-1;
	    	int contador=0;
	    	
	    	while(contador<vendidos.size() && indice==-1) {
	    		if(producto.getCodigoBarras().equalsIgnoreCase(vendidos.get(contador).getCodigoBarras())) {
	    			indice=contador;
	    		}
	    		
	    		contador++;
	    	}
	    	return indice;//si encuentra una coincidencia devolvera el indice, de lo contrario devolvera -1
	    }
	    
	  //crea un objeto producto y lo agrega a la lista de vendidos
	    private void agregarProductoVendido(Producto producto, int unidades) {
	    	
	    	//tambien nos cercioramos si ya hemos vendido este producto anteriormente
	    	int encuentra=verificaProducto(producto);
	    	
	    	//si ya hemos vendido mas unidades sumamos la cantidad nueva
	    	if(encuentra>-1) {
	    		vendidos.get(encuentra).setCantidadDisponible(vendidos.get(encuentra).getCantidadDisponible()+unidades);
	    	//de lo contrario creamos un nuevo producto con la cantidad que hemos vendido y lo guardamos en la lista de vendidos	
	    	}else {
	    	  	Producto vendido=new Producto(producto.getNombre(),producto.getDescripcion(),
		    			producto.getCodigoBarras(),producto.getPrecio(),unidades);
		    	
		        this.vendidos.add(vendido);
	    	}
	    	
	    }
	    
	    //suma las ganacias de las ventas
	    private void ganancias() {
	    	
	    	double gananciasActuales=0;
	    	double gananciaPorProducto=0;
	    	    	
	    	for(int i=0; i<vendidos.size(); i++) {
	    		gananciaPorProducto=vendidos.get(i).getPrecio()*vendidos.get(i).getCantidadDisponible();
	    		gananciasActuales+=gananciaPorProducto;
	    	}
	    	
	    	System.out.println("\t<<Han logrado " + gananciasActuales + " euros de beneficios.>>");
	    }
		
	}

