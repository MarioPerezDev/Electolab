package es.upm.dit.isst.electolab.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class GrupoParlamentario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String voto;
	@Column
	@OneToMany(mappedBy = "grupoParlamentario", fetch = FetchType.EAGER)
	private Collection<Partido> partidosdelgrupo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
	public Collection<Partido> getPartidosdelgrupo() {
		return partidosdelgrupo;
	}
	public void setPartidosdelgrupo(Collection<Partido> partidosdelgrupo) {
		this.partidosdelgrupo = partidosdelgrupo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		GrupoParlamentario other = (GrupoParlamentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GrupoParlamentario [id=" + id + ", nombre=" + nombre + ", voto=" + voto + ", partidosdelgrupo="
				+ partidosdelgrupo + "]";
	}
	public GrupoParlamentario() {
		super();
	}
	
}
