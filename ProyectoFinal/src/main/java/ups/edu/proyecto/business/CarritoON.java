package ups.edu.proyecto.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.proyecto.DAO.CarritoCabeceraDAO;
import ups.edu.proyecto.DAO.ProductoDAO;
import ups.edu.proyecto.modelo.CarritoCabecera;
import ups.edu.proyecto.modelo.CarritoDetalle;
import ups.edu.proyecto.modelo.DetalleFactura;
import ups.edu.proyecto.modelo.Producto;
import ups.edu.proyecto.services.modelo.ProductoTemp;


@Stateless
public class CarritoON {
	
	@Inject
	private ProductoDAO daoProducto;

	@Inject
	private CarritoCabeceraDAO daoCarrito;
	
public void insertCarrito(CarritoCabecera carrito) throws Exception {
		
		daoCarrito.insert(carrito);	
	}

	public void updateCarrito(CarritoCabecera carrito) throws Exception {
		
		daoCarrito.update(carrito);
	}
	
	public void deleteCarrito(CarritoCabecera carrito) throws Exception {
		String com= String.valueOf(carrito.getCodigoCarCab());
		daoCarrito.delete(com);
	}
	
	public CarritoCabecera getCarritoUltimo() {
		
		List<CarritoCabecera> cabeceras= daoCarrito.getCarritoUltimo();
		CarritoCabecera carrito= new CarritoCabecera();
		int longitud= cabeceras.size();
		carrito=cabeceras.get(longitud-1);;
		
		return carrito;
	}
	
	public CarritoCabecera getCarritos(String cedula) {
		CarritoCabecera p= daoCarrito.read(cedula);
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
	
	
	public CarritoDetalle agregarDetalle(ProductoTemp productoTemp, Producto producto) {
		CarritoDetalle detalle=new CarritoDetalle();
		detalle.setCodigoCarDet(productoTemp.getCodigo());
		detalle.setCantidad(productoTemp.getCantidad());
		detalle.setPrecio(producto.getValorUnitario());
		detalle.setProducto(producto);
		
		return detalle;
	}
	
	public CarritoCabecera agregarProducto(Producto producto, ProductoTemp productoTemp) {
		CarritoCabecera carrito = new CarritoCabecera();
		CarritoDetalle detalle= new CarritoDetalle();
		
		if(productoTemp.getEstado().equals("nueva")) {
			//carrito= new CarritoCabecera();
			carrito.setCodigoCarCab(1);
			System.out.println("Nueva");
		}else if(productoTemp.getEstado() == "actual"){
			carrito=getCarritoUltimo();
			System.out.println("Actual: "+carrito.getCodigoCarCab());
		}
		
		detalle=agregarDetalle(productoTemp, producto);
		carrito.agregarDetalle(detalle);
		return carrito;
		
	}
}
