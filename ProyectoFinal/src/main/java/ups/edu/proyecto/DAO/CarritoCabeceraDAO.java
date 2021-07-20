package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.CarritoCabecera;

@Stateless
public class CarritoCabeceraDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(CarritoCabecera carritoCab) {
		em.persist(carritoCab);
	}
	
	public void update(CarritoCabecera carritoCab) {
		em.merge(carritoCab);
	}
	
	public CarritoCabecera read(String cedula) {
		CarritoCabecera p = em.find(CarritoCabecera.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		CarritoCabecera p = em.find(CarritoCabecera.class, cedula);
		em.remove(p);
	}
	
	public List<CarritoCabecera> getCarritoCabeceras(String nombre){
		
		String jpql2="SELECT p FROM CarritoCabecera p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, CarritoCabecera.class);
		query.setParameter(1, nombre);
		
		List<CarritoCabecera> carritoCabeceras=query.getResultList();
		return carritoCabeceras;
		
	}
}
