package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.GrupoParlamentario;

public interface GrupoParlamentarioDAO {
	public void create(GrupoParlamentario grupoparlamentario);
	public GrupoParlamentario read(Integer id);
	public void update(GrupoParlamentario grupoparlamentario);
	public void delete(GrupoParlamentario grupoparlamentario);
	public Collection<GrupoParlamentario> readAll();
	public GrupoParlamentario login(String email, String psd);
}
