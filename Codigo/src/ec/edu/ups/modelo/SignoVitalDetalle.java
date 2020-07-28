package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class SignoVitalDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "SignoVitalCabecera_id", nullable = false)
	private SignoVitalCabecera signoVitalCabecera;
	private String tipo;// Síntomas, Alergias y Enfermedades Previas
	private String descripcion;

	@Transient
	private boolean editable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SignoVitalCabecera getSignoVitalCabecera() {
		return signoVitalCabecera;
	}

	public void setSignoVitalCabecera(SignoVitalCabecera signoVitalCabecera) {
		this.signoVitalCabecera = signoVitalCabecera;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((signoVitalCabecera == null) ? 0 : signoVitalCabecera.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		SignoVitalDetalle other = (SignoVitalDetalle) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (editable != other.editable)
			return false;
		if (id != other.id)
			return false;
		if (signoVitalCabecera == null) {
			if (other.signoVitalCabecera != null)
				return false;
		} else if (!signoVitalCabecera.equals(other.signoVitalCabecera))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SignoVitalDetalle [id=" + id + ", signoVitalCabecera=" + signoVitalCabecera + ", tipo=" + tipo
				+ ", descripcion=" + descripcion + ", editable=" + editable + "]";
	}

}
