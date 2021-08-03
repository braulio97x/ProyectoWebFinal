package ups.edu.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleFactura {
	@Id
	private int codDetFac;
	
	
	@ManyToOne
	@JoinColumn(name = "facCabecera_id")
	private FacturaCabecera facturaCabecera;
	
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	public int getCodDetFac() {
		return codDetFac;
	}

	public void setCodDetFac(int codDetFac) {
		this.codDetFac = codDetFac;
	}

}
