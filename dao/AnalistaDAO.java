package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.Analista;

public interface AnalistaDAO {
	public void create(Analista analista);
	public Analista read(String email);
	public void update(Analista analista);
	public void delete(Analista analista);
	public Collection<Analista> readAll();
	public Analista login(String email, String psd);
}
