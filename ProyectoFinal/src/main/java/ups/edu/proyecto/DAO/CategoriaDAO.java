package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.Categoria;


@Stateless
public class CategoriaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Categoria categoria) {
		em.persist(categoria);
	}
	
	public void update(Categoria categoria) {
		em.merge(categoria);
	}
	
	public Categoria read(int codigo) {
		Categoria p = em.find(Categoria.class, codigo);
		return p;
	}
	
	public void delete(int codigo) {
		Categoria p = em.find(Categoria.class, codigo);
		em.remove(p);
	}
	
	public List<Categoria> getCategorias(String nombre){
		
		String jpql2="SELECT p FROM Categoria p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Categoria.class);
		query.setParameter(1, nombre);
		
		List<Categoria> categorias=query.getResultList();
		return categorias;
		
	}
}
