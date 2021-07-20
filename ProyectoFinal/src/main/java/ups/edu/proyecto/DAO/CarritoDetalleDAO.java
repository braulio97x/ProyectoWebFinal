package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.CarritoDetalle;


@Stateless
public class CarritoDetalleDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(CarritoDetalle carritoDet) {
		em.persist(carritoDet);
	}
	
	public void update(CarritoDetalle carritoDet) {
		em.merge(carritoDet);
	}
	
	public CarritoDetalle read(String cedula) {
		CarritoDetalle p = em.find(CarritoDetalle.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		CarritoDetalle p = em.find(CarritoDetalle.class, cedula);
		em.remove(p);
	}
	
	public List<CarritoDetalle> getCarritoDetalles(String nombre){
		
		String jpql2="SELECT p FROM CarritoDetalle p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, CarritoDetalle.class);
		query.setParameter(1, nombre);
		
		List<CarritoDetalle> carritoDetalles=query.getResultList();
		return carritoDetalles;
		
	}
}
