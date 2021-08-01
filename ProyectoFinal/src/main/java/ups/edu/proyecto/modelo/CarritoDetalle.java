package ups.edu.proyecto.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CarritoDetalle {
	@Id
	private int codigoCarDet;
	private int cantidad;
	private Double precio;
	private Double iva;
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "carrito_cabecera_id")
	private CarritoCabecera carritoCabecera;
	
	/*
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
*/
	@OneToMany
	@JoinColumn(name = "producto_id")
	private List<Producto> productos;
	
	
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

	public CarritoCabecera getCarritoCabecera() {
		return carritoCabecera;
	}

	public void setCarritoCabecera(CarritoCabecera carritoCabecera) {
		this.carritoCabecera = carritoCabecera;
	}

	

	
}
