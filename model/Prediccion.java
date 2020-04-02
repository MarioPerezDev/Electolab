package es.upm.dit.isst.electolab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prediccion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private int likes;
	private int dislikes;
	private String fecha;
	@ManyToOne
	private Analista analista;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public int getLikes() {
		return likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public String getFecha() {
		return fecha;
	}
	public Analista getAnalista() {
		return analista;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setAnalista(Analista analista) {
		this.analista = analista;
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
		Prediccion other = (Prediccion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Prediccion [id=" + id + ", likes=" + likes + ", dislikes=" + dislikes + ", fecha=" + fecha
				+ ", analista=" + analista + "]";
	}
	public Prediccion() {
		super();
	}

}
