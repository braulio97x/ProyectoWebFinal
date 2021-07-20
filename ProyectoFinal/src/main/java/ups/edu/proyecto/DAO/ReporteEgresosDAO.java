package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.ReporteEgresos;

@Stateless
public class ReporteEgresosDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(ReporteEgresos egresos) {
		em.persist(egresos);
	}
	
	public void update(ReporteEgresos egresos) {
		em.merge(egresos);
	}
	
	public ReporteEgresos read(String cedula) {
		ReporteEgresos p = em.find(ReporteEgresos.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		ReporteEgresos p = em.find(ReporteEgresos.class, cedula);
		em.remove(p);
	}
	
	public List<ReporteEgresos> getReporteEgresos(String nombre){
		
		String jpql2="SELECT p FROM ReporteEgresos p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, ReporteEgresos.class);
		query.setParameter(1, nombre);
		
		List<ReporteEgresos> reporteEgresos=query.getResultList();
		return reporteEgresos;
		
	}
}
