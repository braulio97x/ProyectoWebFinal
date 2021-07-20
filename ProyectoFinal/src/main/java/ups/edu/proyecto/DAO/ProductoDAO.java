package ups.edu.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.proyecto.modelo.Producto;


@Stateless
public class ProductoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Producto producto) {
		em.persist(producto);
	}
	
	public void update(Producto producto) {
		em.merge(producto);
	}
	
	public Producto read(int codigo) {
		Producto p = em.find(Producto.class, codigo);
		return p;
	}
	
	public void delete(String cedula) {
		Producto p = em.find(Producto.class, cedula);
		em.remove(p);
	}
	
	public List<Producto> getProductos(String nombre){
		
		String jpql2="SELECT p FROM Producto p WHERE nombre LIKE ?1";
		
		nombre= nombre+"%";
		Query query= em.createQuery(jpql2, Producto.class);
		query.setParameter(1, nombre);
		
		List<Producto> productos=query.getResultList();
		return productos;
		
	}

}
