package es.upm.dit.isst.electolab.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	@Column(unique = true)
	private String name;
	@Column
	private boolean analist;
	@Column
	private boolean accepted;
	@Column
	@OneToMany(mappedBy = "analista", fetch = FetchType.EAGER)
	private Collection<Prediccion> donePredicciones;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "usuariosQueDieronLike")
	private Collection<Prediccion> likedPredictions;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "usuariosQueDieronDislike")
	private Collection<Prediccion> dislikedPredictions;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Usuario.serialVersionUID = serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAnalist() {
		return analist;
	}

	public void setAnalist(boolean analist) {
		this.analist = analist;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public Collection<Prediccion> getDonePredicciones() {
		return donePredicciones;
	}

	public void setDonePredicciones(Collection<Prediccion> donePredicciones) {
		this.donePredicciones = donePredicciones;
	}

	public Collection<Prediccion> getLikedPredictions() {
		return likedPredictions;
	}

	public void setLikedPredictions(Collection<Prediccion> likedPredictions) {
		this.likedPredictions = likedPredictions;
	}

	public Collection<Prediccion> getDislikedPredictions() {
		return dislikedPredictions;
	}

	public void setDislikedPredictions(Collection<Prediccion> dislikedPredictions) {
		this.dislikedPredictions = dislikedPredictions;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", analist="
				+ analist + ", accepted=" + accepted + ", donePredicciones=" + donePredicciones + ", likedPredictions="
				+ likedPredictions + ", dislikedPredictions=" + dislikedPredictions + "]";
	}

	public Usuario() {
		super();
	}
	
	
	
	
	
}
