package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Paciente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CitaMedicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CitaMedicaFacade ejbCitaMedicaFacade;
	private List<CitaMedica> list, listEstado, listRegistro;
	private Paciente paciente;
	private Date fecha;

	public CitaMedicaBean() {

	}

	@PostConstruct
	public void init() {
		// ejbClienteFacade.create(new Cliente(this.nombre="Hugo",
		// this.apellido="Prueba",this.cedula= "000000",this.direccion= "Nuevo",
		// this.correo="Cuenca",this.estado= 'A'));

		listEstado = ejbCitaMedicaFacade.findAll();
		// listEstado = ejbClienteFacade.readCliente('A');
	}

	public String add() {

		System.out.println("Llama al add");
		CitaMedica cm = new CitaMedica();
		cm.setEditable(false);
		cm.setFecha(fecha);
		cm.setPaciente(paciente);
		cm.setSignosVitalesCabecera(null);

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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}