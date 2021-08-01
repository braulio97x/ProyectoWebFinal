package ups.edu.proyecto.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FacturaCabecera {
	@Id
	private int codigoFacCab;
	private int numero;
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	@OneToMany(mappedBy = "facturaCabecera", cascade = CascadeType.ALL)
	private List<DetalleFactura> facturaDetalles;

	public int getCodigoFacCab() {
		return codigoFacCab;
	}

	public void setCodigoFacCab(int codigoFacCab) {
		this.codigoFacCab = codigoFacCab;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
