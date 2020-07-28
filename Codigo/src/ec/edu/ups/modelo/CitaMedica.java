package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class CitaMedica implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "paciente_cedula", nullable = false)
	private Paciente paciente;

	private Date fecha;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "citaMedica")
	private List<SignoVitalCabecera> SignosVitalesCabecera;
	@Transient
	private boolean editable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<SignoVitalCabecera> getSignosVitalesCabecera() {
		return SignosVitalesCabecera;
	}

	public void setSignosVitalesCabecera(List<SignoVitalCabecera> signosVitalesCabecera) {
		SignosVitalesCabecera = signosVitalesCabecera;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SignosVitalesCabecera == null) ? 0 : SignosVitalesCabecera.hashCode());
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CitaMedica other = (CitaMedica) obj;
		if (SignosVitalesCabecera == null) {
			if (other.SignosVitalesCabecera != null)
				return false;
		} else if (!SignosVitalesCabecera.equals(other.SignosVitalesCabecera))
			return false;
		if (editable != other.editable)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", paciente=" + paciente + ", fecha=" + fecha + ", SignosVitalesCabecera="
				+ SignosVitalesCabecera + ", editable=" + editable + "]";
	}

}
