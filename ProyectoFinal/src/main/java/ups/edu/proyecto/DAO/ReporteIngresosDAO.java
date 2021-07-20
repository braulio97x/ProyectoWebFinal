package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.ReporteIngresos;


@Stateless
public class ReporteIngresosDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(ReporteIngresos ingresos) {
		em.persist(ingresos);
	}
	
	public void update(ReporteIngresos ingresos) {
		em.merge(ingresos);
	}
	
	public ReporteIngresos read(String cedula) {
		ReporteIngresos p = em.find(ReporteIngresos.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		ReporteIngresos p = em.find(ReporteIngresos.class, cedula);
		em.remove(p);
	}
	
	public List<ReporteIngresos> getReporteIngresos(String nombre){
		
		String jpql2="SELECT p FROM ReporteIngresos p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, ReporteIngresos.class);
		query.setParameter(1, nombre);
		
		List<ReporteIngresos> reporteIngresos=query.getResultList();
		return reporteIngresos;
		
	}
}
