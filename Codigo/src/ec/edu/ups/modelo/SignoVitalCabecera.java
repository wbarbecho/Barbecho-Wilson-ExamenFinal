package ec.edu.ups.modelo;

import java.io.Serializable;
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
public class SignoVitalCabecera implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "cita_id", nullable = false)
	private CitaMedica citaMedica;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "signoVitalCabecera")
	private List<SignoVitalDetalle> SignosVitalesDetalles;
	//
	private double presion;
	private double frecuenciaCardiaca;
	private double frecuenciaRespiratoria;
	private double temperatura;
	private double saturacion;
	//
	@Transient
	private boolean editable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CitaMedica getCitaMedica() {
		return citaMedica;
	}

	public void setCitaMedica(CitaMedica citaMedica) {
		this.citaMedica = citaMedica;
	}

	public List<SignoVitalDetalle> getSignosVitalesDetalles() {
		return SignosVitalesDetalles;
	}

	public void setSignosVitalesDetalles(List<SignoVitalDetalle> signosVitalesDetalles) {
		SignosVitalesDetalles = signosVitalesDetalles;
	}

	public double getPresion() {
		return presion;
	}

	public void setPresion(double presion) {
		this.presion = presion;
	}

	public double getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(double frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public double getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(double frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getSaturacion() {
		return saturacion;
	}

	public void setSaturacion(double saturacion) {
		this.saturacion = saturacion;
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
		result = prime * result + ((SignosVitalesDetalles == null) ? 0 : SignosVitalesDetalles.hashCode());
		result = prime * result + ((citaMedica == null) ? 0 : citaMedica.hashCode());
		result = prime * result + (editable ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(frecuenciaCardiaca);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(frecuenciaRespiratoria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(presion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saturacion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(temperatura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SignoVitalCabecera other = (SignoVitalCabecera) obj;
		if (SignosVitalesDetalles == null) {
			if (other.SignosVitalesDetalles != null)
				return false;
		} else if (!SignosVitalesDetalles.equals(other.SignosVitalesDetalles))
			return false;
		if (citaMedica == null) {
			if (other.citaMedica != null)
				return false;
		} else if (!citaMedica.equals(other.citaMedica))
			return false;
		if (editable != other.editable)
			return false;
		if (Double.doubleToLongBits(frecuenciaCardiaca) != Double.doubleToLongBits(other.frecuenciaCardiaca))
			return false;
		if (Double.doubleToLongBits(frecuenciaRespiratoria) != Double.doubleToLongBits(other.frecuenciaRespiratoria))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(presion) != Double.doubleToLongBits(other.presion))
			return false;
		if (Double.doubleToLongBits(saturacion) != Double.doubleToLongBits(other.saturacion))
			return false;
		if (Double.doubleToLongBits(temperatura) != Double.doubleToLongBits(other.temperatura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SignoVitalCabecera [id=" + id + ", citaMedica=" + citaMedica + ", SignosVitalesDetalles="
				+ SignosVitalesDetalles + ", presion=" + presion + ", frecuenciaCardiaca=" + frecuenciaCardiaca
				+ ", frecuenciaRespiratoria=" + frecuenciaRespiratoria + ", temperatura=" + temperatura
				+ ", saturacion=" + saturacion + ", editable=" + editable + "]";
	}

}
