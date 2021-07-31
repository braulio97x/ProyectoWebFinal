package ups.edu.proyecto.view;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.proyecto.business.RolON;
import ups.edu.proyecto.business.UsuarioON;
import ups.edu.proyecto.modelo.Rol;
import ups.edu.proyecto.modelo.Usuario;

@Named
@RequestScoped
public class UsuarioBean {
	
	@Inject
	private UsuarioON usuarioON;
	
	@Inject
	private RolON rolON;
	
	private Usuario newUsuario= new Usuario();
	private Rol newRol;
	
	
	
	public Usuario getNewUsuario() {
		return newUsuario;
	}



	public void setNewUsuario(Usuario newUsuario) {
		this.newUsuario = newUsuario;
	}



	public Rol getNewRol() {
		return newRol;
	}



	public void setNewRol(Rol newRol) {
		this.newRol = newRol;
	}



	@PostConstruct
	public void init() {
		if(newUsuario.getRol() == null) {
			newRol = new Rol();
			newRol.setCargo("Invitado");
			newRol=rolON.getRolNombre(newRol.getCargo());
			newUsuario.setRol(newRol);
		
			//usuarioON.insertUsuario(newUsuario);
		}else {
			System.out.println("SI tiene ROL");
		}

	}
	
	public String crearCuenta(){
		String mensaje="";
		try {
			usuarioON.insertUsuario(newUsuario);
			return mensaje="OK";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return mensaje="Error";
		}
	}
	
	public String iniciarSesion() {
		String mensaje="";
		
		newUsuario=usuarioON.iniciarSesion(newUsuario);
		if(newUsuario != null) {
			return mensaje="Existe";
		}else {
			return mensaje="Error no existe cuenta";
		}
		
		
	}
	
	public String probando() {
		String mensaje="Ok";
		System.out.println("Hola");
		return mensaje;
		
	}
	
	public String paginaCrearCliente() {
		return "CrearCliente?faces-redirect=true";
	}
	
	
	
	

}
