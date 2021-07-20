package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.DetalleFactura;

@Stateless
public class FacturaDetalleDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(DetalleFactura facturaDet) {
		em.persist(facturaDet);
	}
	
	public void update(DetalleFactura facturaDet) {
		em.merge(facturaDet);
	}
	
	public DetalleFactura read(String cedula) {
		DetalleFactura p = em.find(DetalleFactura.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		DetalleFactura p = em.find(DetalleFactura.class, cedula);
		em.remove(p);
	}
	
	public List<DetalleFactura> getDetalleFacturas(String nombre){
		
		String jpql2="SELECT p FROM DetalleFactura p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, DetalleFactura.class);
		query.setParameter(1, nombre);
		
		List<DetalleFactura> detalleFacturas=query.getResultList();
		return detalleFacturas;
		
	}
}
