//Paquete de la entidad
package ups.edu.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//Entidad reporte Egresos
@Entity
public class ReporteEgresos {
	//Clave primaria de la entidad
	@Id
	private int codigo;
	
	//Relacion muchos a uno con detalle factura 
	@ManyToOne
	//FOREIGN KEY detFactura_id
	@JoinColumn(name = "detFactura_id")
	private DetalleFactura detalleFactura;
	
	
//Getts y setts
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
