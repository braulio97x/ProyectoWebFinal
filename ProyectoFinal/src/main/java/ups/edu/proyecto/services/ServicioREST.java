package ups.edu.proyecto.services;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ups.edu.proyecto.business.ProductoON;
import ups.edu.proyecto.business.RolON;
import ups.edu.proyecto.business.UsuarioON;
import ups.edu.proyecto.modelo.Producto;
import ups.edu.proyecto.modelo.Rol;
import ups.edu.proyecto.modelo.Usuario;
import ups.edu.proyecto.services.modelo.ProductoTemp;
import ups.edu.proyecto.services.modelo.ProductosTemp;

@Path("personas")
public class ServicioREST {
	
	@Inject
	private UsuarioON usuarioON;
	
	@Inject
	private RolON rolON;
	
	@Inject
	private ProductoON productoON;
	
	@PUT
	@Path("/registrarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensaje registrarUsuario(Usuario newUsuario) {
		//Usuario newUsuario= new Usuario();
		Rol newRol= new Rol();
		//newUsuario.setRol(newRol);
		Mensaje msj= new Mensaje();
		newRol.setCargo("Cliente".toUpperCase());
		newRol=rolON.getRolNombreList(newRol.getCargo());
		newUsuario.setRol(newRol);
		
		try {
			
			//newUsuario.getRol().setCargo("Cliente".toLowerCase());
			//Rol rol = rolON.getRolNombreList(newUsuario.getRol().getCargo());
			//newUsuario.setRol(rol);
			usuarioON.insertUsuario(newUsuario);
			System.out.println(newUsuario.getRol().getCargo());
			msj.setCodigo(1);
			msj.setMensaje("Ok se registro");
			return msj;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msj.setCodigo(2);
			msj.setMensaje("Error" +newUsuario.getRol().getCodigo());
			return msj;
		}
		
		
		
	}
	@PUT
	@Path("/iniciarSesion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensaje iniciarSesion(Usuario newUsuario) {
		Mensaje msj= new Mensaje();
		//String mensaje="";
		//Usuario user= new Usuario();
		newUsuario=usuarioON.iniciarSesion(newUsuario);
		System.out.println("Recupero: "+newUsuario.getCedula());
		System.out.println(newUsuario);
		if(newUsuario.getCedula() != null) {
			if(newUsuario.getRol().getCargo().equals("Cliente".toUpperCase())) {
				msj.setCodigo(1);
				msj.setMensaje("Si existe, iniciado, Cliente");
				return msj;
			}else if(newUsuario.getRol().getCargo().equals("Administrador".toUpperCase())) {
				msj.setCodigo(2);
				msj.setMensaje("Si existe, iniciado, Administrador");
				return msj;
			}
		}else {
			msj.setCodigo(0);
			msj.setMensaje("Error no existe cuenta");
			return msj;
		}
		
		return msj;
	}
	
	@GET
	@Path("recuperar-productos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductosTemp> getProductos(){
		List<Producto> lista = productoON.getProductos();
		List<ProductosTemp> productos = new ArrayList<ProductosTemp>();
		
		//PersonaTemp pert;
		
		for(Producto p: lista) {
			ProductosTemp newProducto= new ProductosTemp();
			newProducto.setCodigo(p.getCodigo());
			newProducto.setNombre(p.getNombre());
			newProducto.setCategoria(p.getCategoria().getNombre());
			newProducto.setValorUnitario(p.getValorUnitario());
			productos.add(newProducto);
		}
		return productos;
	}
	
	@GET
	@Path("recuperar-productos-nombre")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getProductosNombre(@QueryParam("p_a") String nombre){
		List<Producto> lista =productoON.buscarProductos(nombre);
		return lista;
	}
	
	
	@GET
	@Path("recuperar-productos-categoria")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getProductosCategoria(@QueryParam("p_a") String nombre){
		//List<Producto> lista = new ArrayList<Producto>();
		 List<Producto> lista=productoON.recuperarProductoCategoria(nombre);
		
		return lista;
	}
	
}
