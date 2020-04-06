package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.Ley;

public interface LeyDAO {
	public void create(Ley ley);
	public Ley read(Integer id);
	public void update(Ley ley);
	public void delete(Ley ley);
	public Collection<Ley> readAll();
	public Ley login(String email, String psd);
}
