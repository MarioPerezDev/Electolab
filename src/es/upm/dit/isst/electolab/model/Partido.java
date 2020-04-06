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
public class Partido {
	//Variables que tiene un partido
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String nombre;
	@Column(length=2000)
	private String descripcion;
	@Column
	private String voto;
	@Column
	@OneToMany(mappedBy = "partido", fetch = FetchType.EAGER)
	private Collection<Diputado> diputados;	
	@ManyToOne
	private GrupoParlamentario grupoParlamentario;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
	public Collection<Diputado> getDiputados() {
		return diputados;
	}
	public void setDiputados(Collection<Diputado> diputados) {
		this.diputados = diputados;
	}

	public GrupoParlamentario getGrupoParlamentario() {
		return grupoParlamentario;
	}
	public void setGrupoParlamentario(GrupoParlamentario grupoParlamentario) {
		this.grupoParlamentario = grupoParlamentario;
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
		Partido other = (Partido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Partido [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", voto=" + voto
				+ ", diputados=" + diputados + ", grupoParlamentario=" + grupoParlamentario + "]";
	}
	public Partido() {
		super();
	}
	
}
