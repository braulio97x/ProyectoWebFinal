package ups.edu.proyecto.view;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.proyecto.business.CarritoON;

@Named
@ViewScoped
public class CarritoBean {
	
	@Inject
	private CarritoON carritoON;

}
