package ups.edu.proyecto.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.proyecto.DAO.RolDAO;
import ups.edu.proyecto.modelo.Rol;

@Stateless
public class RolON {
	
	@Inject
	private RolDAO daoRol;
	
	
	public void insertRol(Rol rol) throws Exception {
		
		 daoRol.insert(rol);	
	}

	public void updateRol(Rol rol) throws Exception {
		
		
		daoRol.update(rol);
	}
	
	public void deleteRol(int codigo) throws Exception {
		
		
		daoRol.delete(codigo);
	}
	
	public List<Rol> getRols() {
		
		//if(!this.validaCedula(Rol.getCedula()))
			//throw new Exception("Cedula incorrecta");
		//Rol per= daoRol.read("0102930888");
		
		return daoRol.getRoles();
	}

}