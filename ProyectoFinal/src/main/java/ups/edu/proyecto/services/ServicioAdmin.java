package ups.edu.proyecto.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ups.edu.proyecto.business.CategoriaON;
import ups.edu.proyecto.business.ProductoON;
import ups.edu.proyecto.modelo.Categoria;
import ups.edu.proyecto.modelo.Producto;
import ups.edu.proyecto.modelo.Rol;
import ups.edu.proyecto.modelo.Usuario;
import ups.edu.proyecto.services.modelo.ProductoTemp;

@Path("admin")
public class ServicioAdmin {

	@Inject
	private CategoriaON categoriaON;

	@Inject
	private ProductoON productoON;

	@PUT
	@Path("/registrarCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensaje registrarCategoria(Categoria newCategoria) {
		// Usuario newUsuario= new Usuario();
		// Rol newRol= new Rol();
		// newUsuario.setRol(newRol);
		Mensaje msj = new Mensaje();
		// newRol.setCargo("Cliente");

		// newRol=rolON.getRolNombreList(newRol.getCargo());
		// newUsuario.setRol(newRol);

		try {

			// newUsuario.getRol().setCargo("Cliente".toLowerCase());
			// Rol rol = rolON.getRolNombreList(newUsuario.getRol().getCargo());
			// newUsuario.setRol(rol);
			categoriaON.insertCategoria(newCategoria);
			System.out.println(newCategoria.getNombre());
			msj.setCodigo(1);
			msj.setMensaje("Ok se registro");
			return msj;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msj.setCodigo(2);
			msj.setMensaje("Error");
			return msj;
		}

	}

	@PUT
	@Path("/registrarProducto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensaje registrarProducto(ProductoTemp producto) {
		Producto resultado= new Producto();
		Categoria categoria = categoriaON.getCategoriaNombre(producto);
		resultado = productoON.agregarCategoria(producto, categoria);
		Mensaje msj= new Mensaje();
	

		try {

			// newUsuario.getRol().setCargo("Cliente".toLowerCase());
			// Rol rol = rolON.getRolNombreList(newUsuario.getRol().getCargo());
			// newUsuario.setRol(rol);
			productoON.insertProducto(resultado);
			System.out.println(resultado.getNombre());
			msj.setCodigo(1);
			msj.setMensaje("Ok se registro");
			return msj;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msj.setCodigo(2);
			msj.setMensaje("Error: "+resultado.getCodigo() +" "+resultado.getNombre()+" "+resultado.getCategoria().getNombre()+" "+resultado.getCategoria().getCodigo());
			return msj;
		}

	}

}
