package ClaseInventario;

import java.util.ArrayList;

public class Inventario {
	//atributo
    private ArrayList<Producto> enStock;
    
    //constructor
    public Inventario() {
        this.enStock = new ArrayList<>();
        
    }
     
    //Metodos publicos
    public ArrayList<Producto> getEnStock() {
		return enStock;
	}

    //agrega un producto al stock
	public void agregarProducto(Producto producto) {
        this.enStock.add(producto);
    }
    
	//elimina un producto del stock
    public void eliminarProducto(Producto producto) {
        this.enStock.remove(producto);
    }

    //imprime lista de productos en stock
	public void imprimeInventario() {
		
		System.out.println("Unidades en Stock:");
		
		 for (int i=0; i<enStock.size(); i++) {
			if(enStock.get(i).noHay()) {
				System.out.println("\tNo quedan mas " + enStock.get(i).getNombre()+"s.");
				
			}else {
	        	System.out.println("\t"+enStock.get(i));
			}
	     }
		 
		 System.out.println("");
	}
	
	//elimina productos cuya cantidad es igual a 0
	public void actualizaStock() {
		for(int i=0; i<enStock.size(); i++) {//recorro la lista
			if(enStock.get(i).noHay()) {//verifico que producto no tiene stock
				eliminarProducto(enStock.get(i));//elimino el producto cuya cantidad es cero
				i--;//disminuyo la lista ya que cambio al aleliminar un indice
			}
		}
	}
	
}

