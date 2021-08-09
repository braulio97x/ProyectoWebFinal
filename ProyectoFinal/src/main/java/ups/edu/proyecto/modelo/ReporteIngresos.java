//Paquete de la entidad
package ups.edu.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//Entidad Reporte Ingresos
@Entity
public class ReporteIngresos {
	//Clave primaria de la entidad
	@Id
	private int codigo;

	//Relacion muchos a uno con producto
	@ManyToOne
	//FOREIGN KEY producto_id
	@JoinColumn(name="producto_id")
	private Producto producto;
	
	//Relacion muchos a uno con producto
	@ManyToOne
	//FOREIGN KEY usuario_id
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	
	//Getts y setts
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
