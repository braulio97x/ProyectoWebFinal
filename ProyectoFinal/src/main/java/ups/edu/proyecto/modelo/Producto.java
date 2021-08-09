//Paquete de la entidad
package ups.edu.proyecto.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//Entidad Producto
@Entity
public class Producto  implements Serializable{
	//Clave primaria de producto_id
	@Id
	//renombramiento de columna
	@Column(name="producto_id")
	private int codigo;
	private String nombre;
	private int stock;
	private Double valorUnitario;
	//Relacion muchos a uno con categoria
	@ManyToOne
	//FOREIGN KEY categoria_id
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	//getts y setts
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
