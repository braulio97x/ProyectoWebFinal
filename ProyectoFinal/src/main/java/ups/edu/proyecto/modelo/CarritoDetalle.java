package ups.edu.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarritoDetalle {
	@Id
	private int codigoCarDet;
	private int cantidad;
	private Double precio;
	private Double iva;
	private Double total;

	public int getCodigoCarDet() {
		return codigoCarDet;
	}

	public void setCodigoCarDet(int codigoCarDet) {
		this.codigoCarDet = codigoCarDet;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
