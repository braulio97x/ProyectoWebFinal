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

	public Rol read(int codigo) {
		Rol p = em.find(Rol.class, codigo);
		return p;
	}

	public void delete(int codigo) {
		Rol p = em.find(Rol.class, codigo);
		em.remove(p);
	}

	public List<Rol> getRoles() {

		String jpql2 = "SELECT p FROM Rol p";

		// nombre= nombre+"%";
		Query query = em.createQuery(jpql2, Rol.class);
		// query.setParameter(1, nombre);

		List<Rol> roles = query.getResultList();
		return roles;

	}

	public Rol getRolNombre(String nombre) {
		String jpql2 = "SELECT p FROM Rol p" + " WHERE cargo LIKE ?1";

		nombre = nombre + "%";
		Query query = em.createQuery(jpql2, Rol.class);
		query.setParameter(1, nombre);

		Object roles = query.getSingleResult();

		Rol resultado = (Rol) roles;

		//List<Rol> roles = query.getResultList();
		return resultado;
	}
	
	public List<Rol> getRolNombreList(String nombre) {
		String jpql2 = "SELECT p FROM Rol p" + " WHERE cargo LIKE ?1";

		nombre = nombre + "%";
		Query query = em.createQuery(jpql2, Rol.class);
		query.setParameter(1, nombre);

		List<Rol> roles = query.getResultList();

		//Rol resultado = (Rol) roles;

		//List<Rol> roles = query.getResultList();
		return roles;
	}
	
}
