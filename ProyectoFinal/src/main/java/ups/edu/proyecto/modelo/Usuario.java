package ups.edu.proyecto.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String correo;
	private String contrasena;
	
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private Rol rol;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private CarritoCabecera carritoCabecera;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<FacturaCabecera> facturaCabeceras;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public CarritoCabecera getCarritoCabecera() {
		return carritoCabecera;
	}

	public void setCarritoCabecera(CarritoCabecera carritoCabecera) {
		this.carritoCabecera = carritoCabecera;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	

}
