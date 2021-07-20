package ups.edu.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleFactura {
	@Id
	private int codDetFac;

	public int getCodDetFac() {
		return codDetFac;
	}

	public void setCodDetFac(int codDetFac) {
		this.codDetFac = codDetFac;
	}

}
