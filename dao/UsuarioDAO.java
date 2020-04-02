package es.upm.dit.isst.electolab.dao;

import java.util.Collection;

import es.upm.dit.isst.electolab.model.Usuario;

public interface UsuarioDAO {
	public void create(Usuario usuario);
	public Usuario read(String email);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public Collection<Usuario> readAll();
	public Usuario login(String email, String psd);
}
