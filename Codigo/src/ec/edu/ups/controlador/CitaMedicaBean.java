package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Paciente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CitaMedicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CitaMedicaFacade ejbCitaMedicaFacade;
	private List<CitaMedica> list;
	@EJB
	private PacienteFacade ejbPacienteFacade;
	private List<Paciente> listPacientes;
	private Paciente paciente;
	private Date fecha;
	private FaceletContext faceletContext;
	private Date hora;
	private String formId;
	private String cliApellido = "";

	public CitaMedicaBean() {

	}

	@PostConstruct
	public void init() {
		// ejbClienteFacade.create(new Cliente(this.nombre="Hugo",
		// this.apellido="Prueba",this.cedula= "000000",this.direccion= "Nuevo",
		// this.correo="Cuenca",this.estado= 'A'));

		list = ejbCitaMedicaFacade.findAll();
		listPacientes = ejbPacienteFacade.findAll();
		// listEstado = ejbClienteFacade.readCliente('A');
	}

	public String add() {

		System.out.println("Llama al add");
		CitaMedica cm = new CitaMedica();
		cm.setEditable(false);
		cm.setFecha(fecha);
		cm.setPaciente(paciente);
		cm.setSignosVitalesCabecera(null);
		ejbCitaMedicaFacade.create(cm);
		System.out.println(cm);
		return null;
	}

	public void cambiarCodigo() {
		faceletContext = (FaceletContext) FacesContext.getCurrentInstance().getAttributes()
				.get(FaceletContext.FACELET_CONTEXT_KEY);
		formId = (String) faceletContext.getAttribute("formId");
	}

	public void cambiarApellidoAjax(AjaxBehaviorEvent event) {
		cliApellido = (String) ((UIOutput) event.getSource()).getValue();
	}

	public List<Paciente> buscarPaciente() {
		try {

			List<Paciente> busquedas = new ArrayList<Paciente>();
			for (Paciente paciente : listPacientes)
				if (paciente.getCedula().equals(cliApellido))
					busquedas.add(paciente);
			if (busquedas.size() > 0)
				this.paciente = busquedas.get(0);

			return busquedas;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}