package ClaseInventario;

public class Producto {
		//atributos 
	    private String nombre;
	    private String descripcion;
	    private String codigoBarras;
	    private double precio;
	    private int cantidadDisponible;   
	    
	    //constructor
	    public Producto(String nombre, String descripcion, String codigoBarras, double precio, int cantidadDisponible) {
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	        this.codigoBarras = codigoBarras;
	        this.precio = precio;
	        this.cantidadDisponible = cantidadDisponible;
	       
	    }
    
	    // métodos getters y setters
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

		public String getCodigoBarras() {
			return codigoBarras;
		}

		public void setCodigoBarras(String codigoBarras) {
			this.codigoBarras = codigoBarras;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public int getCantidadDisponible() {
			return cantidadDisponible;
		}

		public void setCantidadDisponible(int cantidadDisponible) {
			this.cantidadDisponible = cantidadDisponible;
		}
		
		//devuelve un true o false si tenemos o no mas unidades en stock
		public boolean noHay() {
			return cantidadDisponible==0;
		}

		/*si la cantidad pedida supera la cantidad en Stock devolvemos las
		 * unidades disponibles */
		public int controlaCantidad(int cantidad) {
			
			if(cantidad>cantidadDisponible) {
				System.out.println("Lo sentimos, no disponemos de  " + cantidad +" "
						+ nombre + "s, solamente podemos ofrecerte " + cantidadDisponible + " unidades.\n");
				
				return cantidadDisponible;
			}

			return cantidad;
		}
		
		@Override//referencia que necesitamos de un producto
		public String toString() {
			return  nombre +" "+ descripcion + " ("+cantidadDisponible+ " unds).";
		}
	
		
}
