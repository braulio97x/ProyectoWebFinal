package ups.edu.proyecto.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CarritoCabecera {
	@Id
	private int codigoCarCab;
	private Date fecha;
	
	@ManyToOne()
	@JoinColumn(name ="usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "carritoCabecera", cascade=CascadeType.ALL)
	private List<CarritoDetalle> detalles;
	
	

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

	public void agregarDetalle(CarritoDetalle detalle) {
		
		if(detalles == null) {
			detalles= new ArrayList<CarritoDetalle>();
		}
		detalles.add(detalle);
	}

	public List<CarritoDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<CarritoDetalle> detalles) {
		this.detalles = detalles;
	}
	
	
}
