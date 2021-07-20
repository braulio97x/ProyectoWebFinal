package ups.edu.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReporteEgresos {
	@Id
	private int codigo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
