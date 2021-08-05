package ups.edu.proyecto.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ups.edu.proyecto.business.CarritoON;
import ups.edu.proyecto.business.ProductoON;
import ups.edu.proyecto.modelo.CarritoCabecera;
import ups.edu.proyecto.modelo.Categoria;
import ups.edu.proyecto.modelo.Producto;
import ups.edu.proyecto.services.modelo.CarritoTemp;
import ups.edu.proyecto.services.modelo.ProductoTemp;

@Path("cliente")
public class ServicioCarrito {

	
	@Inject
	private ProductoON productoON;
	
	@Inject
	private CarritoON carritoON;
	
	@PUT
	@Path("/Agregar-al-Carrito")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CarritoTemp agregarProductoCarrito(ProductoTemp producto) {
		Producto resultado= new Producto();
		resultado=productoON.recuperarProductoNombre(producto);
		CarritoCabecera carrito= carritoON.agregarProducto(resultado, producto);
		System.out.println(carrito.getDetalles().get(0).getPrecio());
		//Mensaje msj= new Mensaje();
		CarritoTemp temp= new CarritoTemp();

		try {
			carritoON.insertCarrito(carrito);
			temp.setCodigo(carrito.getCodigoCarCab());
			temp.setCantidad(carrito.getDetalles().get(0).getCantidad());
			temp.setNombre(carrito.getDetalles().get(0).getProducto().getNombre());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			temp.setCodigo(2);
			temp.setNombre("No entro");
			return temp;
		}
		/*
		if(carrito != null) {
			//msj.setCodigo(1);
			//msj.setMensaje("Correcto "+" "+carrito.getCodigoCarCab()+" "+carrito.getDetalles().get(0).getCantidad());
			temp.setCodigo(carrito.getCodigoCarCab());
			temp.setCantidad(carrito.getDetalles().get(0).getCantidad());
			temp.setNombre(carrito.getDetalles().get(0).getProducto().getNombre());
			return temp;
		}else if(carrito == null){
			temp.setCodigo(2);
			temp.setNombre("No entro");
			return temp;
		}
		*/
		
		return temp;

		/*
		try {
			resultado=productoON.recuperarProductoNombre(producto);
			msj.setCodigo(1);
			msj.setMensaje("Correcto "+" "+resultado.getNombre()+" "+resultado.getCategoria().getNombre());
			return msj;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msj.setCodigo(2);
			msj.setMensaje("Incorrecto "+" "+resultado.getNombre()+" "+resultado.getCategoria().getNombre());
			return msj;
		}
		*/
		/*
		try {
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
		*/

	}
}
