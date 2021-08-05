package ups.edu.proyecto.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.proyecto.DAO.ProductoDAO;
import ups.edu.proyecto.modelo.Categoria;
import ups.edu.proyecto.modelo.Producto;
import ups.edu.proyecto.services.modelo.ProductoTemp;

@Stateless
public class ProductoON {

	@Inject
	private ProductoDAO daoProducto;
	
public void insertProducto(Producto producto) throws Exception {
		
		daoProducto.insert(producto);	
	}

	public void updateProducto(Producto producto) throws Exception {
		
		daoProducto.update(producto);
	}
	
	public void deleteProducto(Producto producto) throws Exception {
		String com= String.valueOf(producto.getCodigo());
		daoProducto.delete(com);
	}
	
	public List<Producto> getProductos() {
		
		//if(!this.validaCedula(persona.getCedula()))
			//throw new Exception("Cedula incorrecta");
		//Persona per= daoPersona.read("0102930888");
		
		return daoProducto.getProductos("%");
	}
	
	public Producto getProducto(int codigo) {
		Producto p= daoProducto.read(codigo);
		return p;
	}
	
	/*
	public List ListarCliente() throws Exception {
		
		
		//String cedula= persona.getCedula();
		String nombre="Andres";
		List<Persona> cliente = daoPersona.getPersonas(nombre);
		return cliente;
	}
	*/
	public Producto agregarCategoria(ProductoTemp producto , Categoria categoria) {
		Producto resultado= new Producto();
		resultado.setCodigo(producto.getCodigo());
		resultado.setNombre(producto.getNombre());
		resultado.setValorUnitario(producto.getValorUnitario());
		resultado.setCategoria(categoria);
		return resultado;
	}
	
	public Producto recuperarProductoNombre(ProductoTemp producto) {
		Producto resultado= new Producto();
		String nombre=producto.getNombre();
		System.out.println("Nombre:" +nombre);
		List<Producto> listaproducto= daoProducto.getProductoNombre(nombre);
		for(Producto elemento: listaproducto) {
			resultado.setCodigo(elemento.getCodigo());
			resultado.setNombre(elemento.getNombre());
			resultado.setValorUnitario(elemento.getValorUnitario());
			resultado.setCategoria(elemento.getCategoria());
		}
	System.out.println(resultado.getNombre() +"Recuperado");
		return resultado;
	}
}
