package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.Prediccion;

public interface PrediccionDAO {
	public void create(Prediccion prediccion);
	public Prediccion read(String email);
	public void update(Prediccion prediccion);
	public void delete(Prediccion prediccion);
	public Collection<Prediccion> readAll();
}
