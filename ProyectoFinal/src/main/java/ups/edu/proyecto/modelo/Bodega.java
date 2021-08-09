package ups.edu.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
//Entidad bodega
@Entity
public class Bodega {
	//atributos codigo unico de la bodega
	//cliave primaria de la entidad
	@Id
	private int codigo;

	//getters y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
