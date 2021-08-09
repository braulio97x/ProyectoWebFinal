//Paquete de la clase
package ups.edu.proyecto.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//Entidad carrito detalle
@Entity
public class CarritoDetalle {
	//clave primaria de carrito detalle
	@Id
	private int codigoCarDet;
	private int cantidad;
	private Double precio;
	private Double iva;
	private Double total;
	//Relacion de muchos a uno con carrito cabecera
	@ManyToOne
	//FOREIGN KEY carrito_cabecera_id
	@JoinColumn(name = "carrito_cabecera_id")
	private CarritoCabecera carritoCabecera;
	
	//Relacion uno a uno con producto
	@OneToOne
	//FOREIGN KEY producto_id
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	
	//Getts y setts
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	

	
}
