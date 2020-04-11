package es.upm.dit.isst.electolab.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class GrupoParlamentario {
	private static long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String nombre;
	@Column
	@OneToMany(mappedBy = "grupoParlamentario", fetch = FetchType.EAGER)
	private Collection<Partido> partidosdelgrupo;
	@OneToMany(mappedBy = "grupoParlamentario", fetch = FetchType.EAGER)
	private Collection<VotacionPorGrupo> votaciones;
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		GrupoParlamentario.serialVersionUID = serialVersionUID;
	}
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
	public Collection<Partido> getPartidosdelgrupo() {
		return partidosdelgrupo;
	}
	public void setPartidosdelgrupo(Collection<Partido> partidosdelgrupo) {
		this.partidosdelgrupo = partidosdelgrupo;
	}
	public Collection<VotacionPorGrupo> getVotaciones() {
		return votaciones;
	}
	public void setVotaciones(Collection<VotacionPorGrupo> votaciones) {
		this.votaciones = votaciones;
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
		GrupoParlamentario other = (GrupoParlamentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GrupoParlamentario [id=" + id + ", nombre=" + nombre + ", partidosdelgrupo=" + partidosdelgrupo
				+ ", votaciones=" + votaciones + "]";
	}
	public GrupoParlamentario() {
		super();
	}

	
	
}
