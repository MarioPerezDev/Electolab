package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.Diputado;

public interface DiputadoDAO {
	public void create(Diputado diputado);
	public Diputado read(Integer id);
	public void update(Diputado diputado);
	public void delete(Diputado diputado);
	public Collection<Diputado> readAll();
	public Diputado login(String email, String psd);
}
