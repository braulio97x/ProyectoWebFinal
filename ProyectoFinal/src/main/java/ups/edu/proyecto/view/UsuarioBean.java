package ups.edu.proyecto.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.proyecto.business.RolON;
import ups.edu.proyecto.business.UsuarioON;
import ups.edu.proyecto.modelo.Rol;
import ups.edu.proyecto.modelo.Usuario;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
	
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
		//newUsuario.setRol(newRol);
		//System.out.println(newUsuario.getRol().getCargo());
		//String cargo= newUsuario.getRol().getCargo();
		//Rol rol=rolON.getRolNombreList(cargo);
		//Rol rol2=rolON.getRolNombre(cargo);
		//System.out.println(rol.getCodigo() +" " +rol.getCargo() +" Encontro Rol Query");
		//System.out.println(rol.getCodigo()+" "+rol.getCargo());
		
		return mensaje;
		
	}
	
	public String paginaCrearCliente() {
		return "CrearCliente?faces-redirect=true";
	}
	
	
	
	

}
