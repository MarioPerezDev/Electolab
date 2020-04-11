package es.upm.dit.isst.electolab.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.VotacionPorPartido;

public class VotacionPorPartidoDAOImplementation implements VotacionPorPartidoDAO {

	  private static  VotacionPorPartidoDAOImplementation instancia = null;
	  private VotacionPorPartidoDAOImplementation() {
	  }

	  public static VotacionPorPartidoDAOImplementation getInstance() {
	    if( null == instancia ) 
	      instancia = new VotacionPorPartidoDAOImplementation();
	    return instancia;
	  }
	  
	@SuppressWarnings("unchecked")
	@Override
	public void create(VotacionPorPartido votacionporpartido) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		session.save(votacionporpartido);//Crear
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public VotacionPorPartido read(Integer id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		VotacionPorPartido votacionporpartido = session.get(VotacionPorPartido.class, id);//Read
		session.getTransaction().commit();
		session.close();
		return votacionporpartido;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void update(VotacionPorPartido votacionporpartido) {
		Session session = SessionFactoryService.get().openSession();
		session.saveOrUpdate(votacionporpartido);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void delete(VotacionPorPartido votacionporpartido) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(votacionporpartido);
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Collection<VotacionPorPartido> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<VotacionPorPartido> votacionporpartidos = session.createQuery("from VotacionPorPartido").list();	
		session.getTransaction().commit();
		session.close();
		return votacionporpartidos;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public VotacionPorPartido login(String email, String psd) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		VotacionPorPartido u = null;
		Query q = session.createQuery("select u from VotacionPorPartido u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<VotacionPorPartido> users = q.getResultList();
		if (users.size() > 0)
			u = (VotacionPorPartido) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
