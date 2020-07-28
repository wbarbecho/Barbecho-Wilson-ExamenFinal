package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.modelo.Paciente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PacienteFacade ejbPacienteFacade;
	private List<Paciente> list;

	public PacienteBean() {

	}

	@PostConstruct
	public void init() {

		Paciente paciente = new Paciente();
		paciente.setApellidos("Castillo");
		paciente.setCedula("0104532554");
		paciente.setCitasMedicas(null);
		paciente.setCorreo("castillo@gmail.com");
		paciente.setDireccion("Remigio");
		paciente.setEditable(false);
		paciente.setNombres("Edwin");
		paciente.setTelefono("0998234512");
		ejbPacienteFacade.create(paciente);
		paciente.setApellidos("Carrion");
		paciente.setCedula("0104753058");
		paciente.setCitasMedicas(null);
		paciente.setCorreo("carolinac@gmail.com");
		paciente.setDireccion("Centro");
		paciente.setEditable(false);
		paciente.setNombres("Carolina");
		paciente.setTelefono("0995138420");
		ejbPacienteFacade.create(paciente);

		list = ejbPacienteFacade.findAll();
		System.out.println(list);
	}

	public List<Paciente> getList() {
		return list;
	}

	public void setList(List<Paciente> list) {
		this.list = list;
	}

	public PacienteFacade getEjbPacienteFacade() {
		return ejbPacienteFacade;
	}

	public void setEjbPacienteFacade(PacienteFacade ejbPacienteFacade) {
		this.ejbPacienteFacade = ejbPacienteFacade;
	}

}