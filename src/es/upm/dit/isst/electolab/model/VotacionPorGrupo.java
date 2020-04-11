package es.upm.dit.isst.electolab.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class VotacionPorGrupo {
	private static long serialVersionUID = 1L;
	//Variables de la ley
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String voto;
	@ManyToOne
	private Prediccion prediccion;
	@ManyToOne
	private GrupoParlamentario grupoParlamentario;
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		VotacionPorGrupo.serialVersionUID = serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
	public Prediccion getPrediccion() {
		return prediccion;
	}
	public void setPrediccion(Prediccion prediccion) {
		this.prediccion = prediccion;
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
		VotacionPorGrupo other = (VotacionPorGrupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VotacionPorGrupo [id=" + id + ", voto=" + voto + ", prediccion=" + prediccion + ", grupoParlamentario="
				+ grupoParlamentario + "]";
	}
	public VotacionPorGrupo() {
		super();
	}

	
	
}
