package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.VotacionPorGrupo;

public interface VotacionPorGrupoDAO {
	public void create(VotacionPorGrupo votacionporgrupo);
	public VotacionPorGrupo read(Integer id);
	public void update(VotacionPorGrupo votacionporgrupo);
	public void delete(VotacionPorGrupo votacionporgrupo);
	public Collection<VotacionPorGrupo> readAll();
	public VotacionPorGrupo login(String email, String psd);
}
