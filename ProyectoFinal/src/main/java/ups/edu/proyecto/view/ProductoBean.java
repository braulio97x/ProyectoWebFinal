package ups.edu.proyecto.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.proyecto.business.ProductoON;
import ups.edu.proyecto.modelo.Categoria;
import ups.edu.proyecto.modelo.Producto;

@Named
@RequestScoped
public class ProductoBean {

	private Producto newProducto = new Producto();
	private List<Producto> productos;
	private Categoria newCategoria= new Categoria();
	
	@Inject
	private ProductoON productoON;
	//@Inject
	//private Categ
	
	public Producto getNewProducto() {
		return newProducto;
	}
	public void setNewProducto(Producto newProducto) {
		this.newProducto = newProducto;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	public Categoria getNewCategoria() {
		return newCategoria;
	}
	public void setNewCategoria(Categoria newCategoria) {
		this.newCategoria = newCategoria;
	}
	@PostConstruct
	public void init() {
		productos=productoON.getProductos();
		System.out.println(productos);
	}
	/*
	public agregarProducto() {
		String categoria = 
	}
	*/
	
}
