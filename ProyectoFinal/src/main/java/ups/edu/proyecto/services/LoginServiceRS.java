package ups.edu.proyecto.services;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ups.edu.proyecto.business.RolON;
import ups.edu.proyecto.business.UsuarioON;
import ups.edu.proyecto.modelo.Rol;
import ups.edu.proyecto.modelo.Usuario;


@Named
@SessionScoped
@Path("CrearCuenta")
public class LoginServiceRS {

	private Usuario newUsuario= new Usuario();
	@Inject
	private UsuarioON usuarioON;
	
	@Inject
	private RolON rolON;
	
	
	

	@PUT
	@Path("/registrar")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String crearCuenta(){
		String mensaje="";
		try {
			newUsuario.getRol().setCargo("Cliente");
			Rol rol = rolON.getRolNombreList(newUsuario.getRol().getCargo());
			newUsuario.setRol(rol);
			usuarioON.insertUsuario(newUsuario);
			System.out.println(newUsuario.getRol().getCargo());
			return "IniciarSesion?faces-redirect=true";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return mensaje="Error";
		}
	}
	
}
