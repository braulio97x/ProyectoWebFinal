package ups.edu.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReporteEgresos {
	@Id
	private int codigo;
	
	
	@ManyToOne
	@JoinColumn(name = "detFactura_id")
	private DetalleFactura detalleFactura;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
