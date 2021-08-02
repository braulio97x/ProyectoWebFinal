package ups.edu.proyecto.services;

import javax.annotation.PostConstruct;
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




@Path("CrearCuenta")
public class LoginServiceRS {

	
	@Inject
	private UsuarioON usuarioON;
	
	@Inject
	private RolON rolON;
	
	private Usuario newUsuario= new Usuario();
	private Rol newRol;
	
	
	
	
	
	public void init() {
		if(newUsuario.getRol() == null) {
			newRol = new Rol();
			newRol.setCargo("Invitado");
			//System.out.println(newRol.getCargo());
			newRol=rolON.getRolNombreList(newRol.getCargo());
			System.out.println(newRol.getCargo());
			newUsuario.setRol(newRol);
			System.out.println("Con Usuario "+ newUsuario.getRol().getCargo() + " "+newUsuario.getRol().getCodigo());
		
			//usuarioON.insertUsuario(newUsuario);
		}else {
			System.out.println("SI tiene ROL");
		}

	}
	

	@PUT
	@Path("/registrar")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String crearCuenta(Usuario usuario){
		String mensaje="";
		try {
			
			Rol r=new Rol();
			int codigo=3;
			r.setCodigo(codigo);
			//r=rolON.readRol(r.getCodigo());
			usuario.setRol(r);
			//newUsuario.getRol().getCodigo();
			//Rol rol = rolON.getRolNombreList(newUsuario.getRol().getCargo());
			//newUsuario.setRol(rol);
			usuarioON.insertUsuario(usuario);
			//System.out.println(newUsuario.getRol().getCargo());
			return mensaje="ingreso";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return mensaje="Error"+ usuario.getRol().getCargo();
		}
	}
	
	
	
	@PUT
	@Path("/iniciarSesion")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String iniciarSesion(Usuario usuario) {
		String mensaje="";
		Usuario user= new Usuario();
		usuario=usuarioON.iniciarSesion(usuario);
		//System.out.println("Recupero: "+newUsuario.getCedula());
		//System.out.println(newUsuario);
		if(usuario.getCedula() != null) {
			return mensaje="Sesion Iniciada por "+ usuario.getNombre();
		}else {
			return mensaje="Error no existe cuenta";
		}
		
		
	}
	
}
