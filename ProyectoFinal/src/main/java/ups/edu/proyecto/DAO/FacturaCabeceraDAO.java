package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.FacturaCabecera;


@Stateless
public class FacturaCabeceraDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(FacturaCabecera facturaCab) {
		em.persist(facturaCab);
	}
	
	public void update(FacturaCabecera facturaCab) {
		em.merge(facturaCab);
	}
	
	public FacturaCabecera read(int codigo) {
		FacturaCabecera p = em.find(FacturaCabecera.class, codigo);
		return p;
	}
	
	public void delete(String cedula) {
		FacturaCabecera p = em.find(FacturaCabecera.class, cedula);
		em.remove(p);
	}
	
	public List<FacturaCabecera> getFacturaCabeceras(String nombre){
		
		String jpql2="SELECT p FROM FacturaCabecera p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, FacturaCabecera.class);
		query.setParameter(1, nombre);
		
		List<FacturaCabecera> facturaCabeceras=query.getResultList();
		return facturaCabeceras;
		
	}
}
