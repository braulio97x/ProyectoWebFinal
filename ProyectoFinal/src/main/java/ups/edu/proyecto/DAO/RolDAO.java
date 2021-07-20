package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.Rol;


@Stateless
public class RolDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Rol rol) {
		em.persist(rol);
	}
	
	public void update(Rol rol) {
		em.merge(rol);
	}
	
	public Rol read(String cedula) {
		Rol p = em.find(Rol.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		Rol p = em.find(Rol.class, cedula);
		em.remove(p);
	}
	
	public List<Rol> getRoles(String nombre){
		
		String jpql2="SELECT p FROM Rol p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Rol.class);
		query.setParameter(1, nombre);
		
		List<Rol> roles=query.getResultList();
		return roles;
		
	}
}
