package es.upm.dit.isst.electolab.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Prediccion implements Serializable {
	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String fecha;
	@ManyToOne
	private Usuario analista;
	@ManyToOne
	private Ley ley;
	
	@OneToMany(mappedBy = "prediccion", fetch = FetchType.EAGER)
	private Collection<VotacionPorGrupo> votacionesGrupo;
	
	@OneToMany(mappedBy = "prediccion", fetch = FetchType.EAGER)
	private Collection<VotacionPorPartido> votacionesPartido;
	
	@OneToMany(mappedBy = "prediccion", fetch = FetchType.EAGER)
	private Collection<VotacionPorDiputado> votacionesDiputado;

	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "likes", 
        joinColumns = { @JoinColumn(name = "prediccion_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "usuario_id") })
	private Collection<Usuario> usuariosQueDieronLike;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "dislikes", 
        joinColumns = { @JoinColumn(name = "prediccion_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "usuario_id") })
	private Collection<Usuario> usuariosQueDieronDislike;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Prediccion.serialVersionUID = serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Usuario getAnalista() {
		return analista;
	}

	public void setAnalista(Usuario analista) {
		this.analista = analista;
	}

	public Ley getLey() {
		return ley;
	}

	public void setLey(Ley ley) {
		this.ley = ley;
	}

	public Collection<VotacionPorGrupo> getVotacionesGrupo() {
		return votacionesGrupo;
	}

	public void setVotacionesGrupo(Collection<VotacionPorGrupo> votacionesGrupo) {
		this.votacionesGrupo = votacionesGrupo;
	}

	public Collection<VotacionPorPartido> getVotacionesPartido() {
		return votacionesPartido;
	}

	public void setVotacionesPartido(Collection<VotacionPorPartido> votacionesPartido) {
		this.votacionesPartido = votacionesPartido;
	}

	public Collection<VotacionPorDiputado> getVotacionesDiputado() {
		return votacionesDiputado;
	}

	public void setVotacionesDiputado(Collection<VotacionPorDiputado> votacionesDiputado) {
		this.votacionesDiputado = votacionesDiputado;
	}

	public Collection<Usuario> getUsuariosQueDieronLike() {
		return usuariosQueDieronLike;
	}

	public void setUsuariosQueDieronLike(Collection<Usuario> usuariosQueDieronLike) {
		this.usuariosQueDieronLike = usuariosQueDieronLike;
	}
	
	public void addUserLike(Usuario usuarioQueDaLike) {
		this.usuariosQueDieronLike.add(usuarioQueDaLike);
	}
	public void removeUserLike(Usuario user) {
		this.usuariosQueDieronLike.remove(user);
	}
	

	public Collection<Usuario> getUsuariosQueDieronDislike() {
		return usuariosQueDieronDislike;
	}

	public void setUsuariosQueDieronDislike(Collection<Usuario> usuariosQueDieronDislike) {
		this.usuariosQueDieronDislike = usuariosQueDieronDislike;
	}
	
	public void addUserDislike(Usuario usuarioQueDaDislike) {
		this.usuariosQueDieronDislike.add(usuarioQueDaDislike);
	}
	
	public void removeUserDislike(Usuario user) {
		this.usuariosQueDieronDislike.remove(user);
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
		return "Prediccion [id=" + id + ", fecha=" + fecha	+ ", analista=" + analista + ", ley=" + ley + ", votacionesGrupo=" + votacionesGrupo
				+ ", votacionesPartido=" + votacionesPartido + ", votacionesDiputado=" + votacionesDiputado
				+ ", usuariosQueDieronLike=" + usuariosQueDieronLike + ", usuariosQueDieronDislike="
				+ usuariosQueDieronDislike + "]";
	}

	public Prediccion() {
		super();
	}
	

}
