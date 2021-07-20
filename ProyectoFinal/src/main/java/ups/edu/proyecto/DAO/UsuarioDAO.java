package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.Usuario;

@Stateless
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void update(Usuario usuario) {
		em.merge(usuario);
	}
	
	public Usuario read(String cedula) {
		Usuario p = em.find(Usuario.class, cedula);
		return p;
	}
	
	public void delete(String cedula) {
		Usuario p = em.find(Usuario.class, cedula);
		em.remove(p);
	}
	
	public List<Usuario> getUsuarios(String nombre){
		
		String jpql2="SELECT p FROM Usuario p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Usuario.class);
		query.setParameter(1, nombre);
		
		List<Usuario> usuarios=query.getResultList();
		return usuarios;
		
	}

}
