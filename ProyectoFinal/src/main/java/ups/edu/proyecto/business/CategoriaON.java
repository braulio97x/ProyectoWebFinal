package ups.edu.proyecto.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.proyecto.DAO.CategoriaDAO;
import ups.edu.proyecto.modelo.Categoria;
import ups.edu.proyecto.modelo.Producto;
import ups.edu.proyecto.services.modelo.ProductoTemp;

@Stateless
public class CategoriaON {
	
	@Inject
	private CategoriaDAO daoCategoria;
	
	public void insertCategoria(Categoria Categoria) throws Exception {
		
		daoCategoria.insert(Categoria);	
	}

	public void updateCategoria(Categoria Categoria) throws Exception {
		
		daoCategoria.update(Categoria);
	}
	
	public void deleteProducto(int codigo) throws Exception {
		//String com= String.valueOf(Categoria.getCedula());
		daoCategoria.delete(codigo);
	}
	
	public List<Categoria> getCategorias() {
		
		//if(!this.validaCedula(persona.getCedula()))
			//throw new Exception("Cedula incorrecta");
		//Persona per= daoPersona.read("0102930888");
		
		return daoCategoria.getCategorias();
	}
	
	public Categoria getCategoriaNombre(ProductoTemp producto){
		String nombre= producto.getCategoria();
		List<Categoria> categorias = daoCategoria.getCategoriaNombre(nombre);
		Categoria resultado = new Categoria();
		for(Categoria elemento:categorias) {
			resultado.setCodigo(elemento.getCodigo());
			resultado.setNombre(elemento.getNombre());
		}
		System.out.println(resultado.getNombre() +" "+ resultado.getCodigo());
		return resultado;
	}

}
