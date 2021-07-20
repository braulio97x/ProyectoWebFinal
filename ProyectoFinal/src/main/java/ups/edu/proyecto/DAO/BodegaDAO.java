package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.Bodega;

@Stateless
public class BodegaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Bodega bodega) {
		em.persist(bodega);
	}
	
	public void update(Bodega bodega) {
		em.merge(bodega);
	}
	
	public Bodega read(String cedula) {
		Bodega p = em.find(Bodega.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		Bodega p = em.find(Bodega.class, cedula);
		em.remove(p);
	}
	
	public List<Bodega> getBodegas(String nombre){
		
		String jpql2="SELECT p FROM Bodega p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Bodega.class);
		query.setParameter(1, nombre);
		
		List<Bodega> bodegas=query.getResultList();
		return bodegas;
		
	}
}
