package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.VotacionPorDiputado;

public interface VotacionPorDiputadoDAO {
	public void create(VotacionPorDiputado votacionpordiputado);
	public VotacionPorDiputado read(Integer id);
	public void update(VotacionPorDiputado votacionpordiputado);
	public void delete(VotacionPorDiputado votacionpordiputado);
	public Collection<VotacionPorDiputado> readAll();
	public VotacionPorDiputado login(String email, String psd);
}
