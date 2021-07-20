package ups.edu.proyecto.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FacturaCabecera {
	@Id
	private int codigoFacCab;
	private int numero;
	private Date fecha;

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
