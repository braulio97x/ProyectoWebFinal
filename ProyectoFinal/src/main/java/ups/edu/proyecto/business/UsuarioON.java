package ups.edu.proyecto.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.proyecto.DAO.UsuarioDAO;
import ups.edu.proyecto.modelo.Usuario;


@Stateless
public class UsuarioON {

	@Inject
	private UsuarioDAO daoUsuario;
	
public void insertUsuario(Usuario usuario) throws Exception {
		
		daoUsuario.insert(usuario);	
	}

	public void updateUsuario(Usuario usuario) throws Exception {
		
		daoUsuario.update(usuario);
	}
	
	public void deleteProducto(Usuario usuario) throws Exception {
		String com= String.valueOf(usuario.getCedula());
		daoUsuario.delete(com);
	}
	
	public List<Usuario> getUsuarios() {
		
		//if(!this.validaCedula(persona.getCedula()))
			//throw new Exception("Cedula incorrecta");
		//Persona per= daoPersona.read("0102930888");
		
		return daoUsuario.getUsuarios("%");
	}
	
	public Usuario getUsuario(String cedula) {
		Usuario p= daoUsuario.read(cedula);
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
	
	public Usuario iniciarSesion(Usuario usuario) {
		List<Usuario> usuarios= daoUsuario.getIniciarSesion(usuario);
		Usuario resultado= new Usuario();
		for(Usuario elemento: usuarios) {
			resultado.setCedula(elemento.getCedula());
			resultado.setNombre(elemento.getNombre());
			resultado.setDireccion(elemento.getDireccion());
			resultado.setApellido(elemento.getApellido());
			resultado.setRol(elemento.getRol());
			resultado.setCorreo(elemento.getCorreo());
			resultado.setContrasena(elemento.getContrasena());
			
			System.out.println("Elemento: "+elemento.getCorreo());
		}
		return resultado;
	}
	
	
}
