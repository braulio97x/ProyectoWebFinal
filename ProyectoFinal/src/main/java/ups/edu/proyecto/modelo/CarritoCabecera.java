package ups.edu.proyecto.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CarritoCabecera {
	@Id
	private int codigoCarCab;
	private Date fecha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "carritoCabecera", cascade = CascadeType.ALL)
	private List<CarritoDetalle> carritoDetalles;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<CarritoDetalle> getCarritoDetalles() {
		return carritoDetalles;
	}

	public void setCarritoDetalles(List<CarritoDetalle> carritoDetalles) {
		this.carritoDetalles = carritoDetalles;
	}

	
	
}
