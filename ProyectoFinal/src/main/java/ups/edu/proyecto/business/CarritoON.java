package ups.edu.proyecto.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.proyecto.DAO.CarritoCabeceraDAO;

import ups.edu.proyecto.modelo.CarritoCabecera;


@Stateless
public class CarritoON {

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
	
	public List<CarritoCabecera> getCarrito() {
		
		//if(!this.validaCedula(persona.getCedula()))
			//throw new Exception("Cedula incorrecta");
		//Persona per= daoPersona.read("0102930888");
		
		return daoCarrito.getCarritoCabeceras("%");
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
	
}
