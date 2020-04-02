package es.upm.dit.isst.electolab.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ley {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String resultado;
	private String nombre;
	private Date fecha;
	private String descripcion;
	public Ley() {
		super();
	}
	@Override
	public String toString() {
		return "Ley [id=" + id + ", resultado=" + resultado + ", nombre=" + nombre + ", fecha=" + fecha
				+ ", descripcion=" + descripcion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ley other = (Ley) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getId() {
		return id;
	}
	public String getResultado() {
		return resultado;
	}
	public String getNombre() {
		return nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}

	
}
