package es.upm.dit.isst.electolab.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class VotacionPorDiputado {
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
	private Diputado diputado;
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		VotacionPorDiputado.serialVersionUID = serialVersionUID;
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
	public Diputado getDiputado() {
		return diputado;
	}
	public void setDiputado(Diputado diputado) {
		this.diputado = diputado;
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
		VotacionPorDiputado other = (VotacionPorDiputado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VotacionPorDiputado [id=" + id + ", voto=" + voto + ", prediccion=" + prediccion + ", diputado="
				+ diputado + "]";
	}
	public VotacionPorDiputado() {
		super();
	}

}
