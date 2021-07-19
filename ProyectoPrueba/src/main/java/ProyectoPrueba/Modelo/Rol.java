package ProyectoPrueba.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rol {
	
	@Id
	private int codigo;
	private String cargo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
