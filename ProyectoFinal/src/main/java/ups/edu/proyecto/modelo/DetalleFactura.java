//Paquete de la entidad
package ups.edu.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//Entidad detalle factura
@Entity
public class DetalleFactura {
	//Clave primaria de la entidad
	@Id
	//Renombramiento de columna
	@Column(name="detFactura_id")
	private int codDetFac;
	
	//Relacion muchos a uno con factura cabecera
	@ManyToOne
	//FOREIGN KEY Factura Cabecera
	@JoinColumn(name = "facCabecera_id")
	private FacturaCabecera facturaCabecera;
	
	//Relacion muchos a uno con factura cabecera
	@ManyToOne
	//FOREIGN KEY producto
	@JoinColumn(name = "producto_id")
	private Producto producto;

	
	
	//getts y setts
	public int getCodDetFac() {
		return codDetFac;
	}

	public void setCodDetFac(int codDetFac) {
		this.codDetFac = codDetFac;
	}

}
