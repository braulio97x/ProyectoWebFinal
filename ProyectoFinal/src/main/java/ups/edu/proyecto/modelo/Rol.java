//Paquete de la entidad
package ups.edu.proyecto.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//Entidad Rol
@Entity
public class Rol {
	//Clave primaria de la entidad
	@Id
	//Renombramiento de columna
	@Column(name="rol_id")
	private int codigo;
	private String cargo;
	
	//Getts y setts
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
