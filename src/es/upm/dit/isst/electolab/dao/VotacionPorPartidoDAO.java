package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.VotacionPorPartido;

public interface VotacionPorPartidoDAO {
	public void create(VotacionPorPartido votacionporpartido);
	public VotacionPorPartido read(Integer id);
	public void update(VotacionPorPartido votacionporpartido);
	public void delete(VotacionPorPartido votacionporpartido);
	public Collection<VotacionPorPartido> readAll();
	public VotacionPorPartido login(String email, String psd);
}
