package ups.edu.proyecto.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.proyecto.DAO.FacturaCabeceraDAO;
import ups.edu.proyecto.modelo.FacturaCabecera;

@Stateless
public class FacturaON {

	@Inject
	private FacturaCabeceraDAO daoFactura;
	
public void insertFactura(FacturaCabecera producto) throws Exception {
		
		daoFactura.insert(producto);	
	}

	public void updateFactura(FacturaCabecera producto) throws Exception {
		
		daoFactura.update(producto);
	}
	
	public void deleteFactura(FacturaCabecera factura) throws Exception {
		String com= String.valueOf(factura.getCodigoFacCab());
		daoFactura.delete(com);
	}
	
	public List<FacturaCabecera> getFacturaCabeceras() {
		
		//if(!this.validaCedula(persona.getCedula()))
			//throw new Exception("Cedula incorrecta");
		//Persona per= daoPersona.read("0102930888");
		
		return daoFactura.getFacturaCabeceras("%");
	}
	
	public FacturaCabecera getFacturaCabecera(int codigo) {
		FacturaCabecera p= daoFactura.read(codigo);
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
