//paquete de la clase
package ups.edu.proyecto.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Entidad Categoria
@Entity
public class Categoria {
	//Clave primaria de categoria
	@Id
	//FOREIGN KEY categoria_id
	@Column(name="categoria_id")
	private int codigo;
	private String nombre;
	
	
	//getts y setts
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

}
