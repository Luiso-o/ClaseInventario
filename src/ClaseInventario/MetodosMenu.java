package ClaseInventario;

import javax.swing.JOptionPane;

public class MetodosMenu {
	
	public static int menu() {
		String opcion=JOptionPane.showInputDialog("Elija una opcion\n\t1-Agregar un producto.\n\t2-Realizar una venta"
				+ "\n\t3-Ver inventario.\n\t4-Ver ventas\n\t0-Salir.");
		
		return Integer.parseInt(opcion);
		
	}
	
	//pide al usuario los datos del producto para dar de alta
	public static void agregaNuevoProducto(Inventario miInventario) {
		//recojo los datos que el usuario introduce por un mensaje impreso
		String nombre = JOptionPane.showInputDialog("Introduce el tipo de producto");
		String descripcion = JOptionPane.showInputDialog("Que marca es la/el " + nombre );
		String codigoBarras = JOptionPane.showInputDialog("Introduce el codigo de barras (10 digitos) ");
		verificaCodigoDeBarras(codigoBarras);//verifico que el codigo de barras cumpla con las caracteristicas
		String texto1 = JOptionPane.showInputDialog("Introduce le precio");
		double precio = Double.parseDouble(texto1);
		String texto2 = JOptionPane.showInputDialog("Introduce las unidades disponibles");
		int cantidadDisponible= Integer.parseInt(texto2);
		
		//guarda un nuevo producto en el inventario
		miInventario.agregarProducto(new Producto(nombre,descripcion,codigoBarras,precio,cantidadDisponible));
		
	}
	
	//devuelve un codigo de barras valido
	private static String verificaCodigoDeBarras(String codigoBarras) {
		
		if(codigoBarras.length()!=10) {//si el codigo de barras no tiene 10 digitos entra en el bucle
			while(codigoBarras.length()!=10) {//pedimos al usuario que reecriba el codigo de barras las veces que sean necesarias
				codigoBarras= JOptionPane.showInputDialog("El codigo de barras debe tener una longitud de 10 caracteres");
				codigoBarras.length();//verificamos que la rectificacion sea correcta
			}
		}
		return codigoBarras;//devolvemos un codigo de barras con 10 digitos
	}
	
	//Realizamos una venta a partir del menu
	public static void hacerVenta(Inventario inventario, Venta venta) {
		
		String lista = "";//creo la lista que imprimiré en pantalla con las opciones modificadas
		inventario.actualizaStock();//modifico el inventario para que imprima solo los productos con stock
	
		//mostramos la lista actualizada con JOptionPane 
		for(int i=0; i<inventario.getEnStock().size(); i++) {
			lista+=inventario.getEnStock().get(i).getNombre()+"\n\t";
		}
		
		//pido una opcion al usuario
		String texto = JOptionPane.showInputDialog("Que producto desea comprar?\n" + lista);
		int indice=buscaIndicePorNombre(inventario,texto);
		
		//verifico si la opcion es compatible con el Stock
		if(indice==-1) {
			JOptionPane.showMessageDialog(null, texto + " No aparece en Stock ");
		}else {
			
			//verifico que las unidades sean compatibles con la cantidad que tenemos en stock		
			texto = JOptionPane.showInputDialog("Cuantas unidades desea comprar?");
			int cantidad = Integer.parseInt(texto);
			inventario.getEnStock().get(indice).controlaCantidad(cantidad);//devolveremos una cantidad valida
			
			//si todo esta correcto envio los datos a ventas
			venta.realizarVenta(inventario.getEnStock().get(indice), cantidad);
		}
	}
	
	//me devuelve el indice de un producto deacuerdo a su nombre
	private static int buscaIndicePorNombre(Inventario inventario, String nombre) {
		
		int indice=-1;
		int encontrado=0;
		
		while(encontrado<inventario.getEnStock().size() && indice==-1) {
			if(inventario.getEnStock().get(encontrado).getNombre().equalsIgnoreCase(nombre)) {
				indice=encontrado;
			}
			
			encontrado++;
		}
		return indice;
	}
	
}
