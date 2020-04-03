package es.upm.dit.isst.electolab.model;

import java.io.Serializable;
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
public class Analista implements Serializable{
	private static final long serialVersionUID = 1L;
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

	public Analista() {
		super();
	}

	@Override
	public String toString() {
		return "Analista [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", donePredicciones=" + donePredicciones + "]";
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
		Analista other = (Analista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@OneToMany(mappedBy = "analista", fetch = FetchType.EAGER)
	private Collection<Prediccion> donePredicciones;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDonePredicciones(Collection<Prediccion> donePredicciones) {
		this.donePredicciones = donePredicciones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public Collection<Prediccion> getDonePredicciones() {
		return donePredicciones;
	}

}