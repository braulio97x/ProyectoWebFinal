package ups.edu.proyecto.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarritoCabecera {
	@Id
	private int codigoCarCab;
	private Date fecha;

	public int getCodigoCarCab() {
		return codigoCarCab;
	}

	public void setCodigoCarCab(int codigoCarCab) {
		this.codigoCarCab = codigoCarCab;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
