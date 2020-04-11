package es.upm.dit.isst.electolab.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.VotacionPorGrupo;

public class VotacionPorGrupoDAOImplementation implements VotacionPorGrupoDAO {

	  private static  VotacionPorGrupoDAOImplementation instancia = null;
	  private VotacionPorGrupoDAOImplementation() {
	  }

	  public static VotacionPorGrupoDAOImplementation getInstance() {
	    if( null == instancia ) 
	      instancia = new VotacionPorGrupoDAOImplementation();
	    return instancia;
	  }
	  
	@SuppressWarnings("unchecked")
	@Override
	public void create(VotacionPorGrupo votacionporgrupo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		session.save(votacionporgrupo);//Crear
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public VotacionPorGrupo read(Integer id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		VotacionPorGrupo votacionporgrupo = session.get(VotacionPorGrupo.class, id);//Read
		session.getTransaction().commit();
		session.close();
		return votacionporgrupo;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void update(VotacionPorGrupo votacionporgrupo) {
		Session session = SessionFactoryService.get().openSession();
		session.saveOrUpdate(votacionporgrupo);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void delete(VotacionPorGrupo votacionporgrupo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(votacionporgrupo);
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Collection<VotacionPorGrupo> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<VotacionPorGrupo> votacionporgrupos = session.createQuery("from VotacionPorGrupo").list();	
		session.getTransaction().commit();
		session.close();
		return votacionporgrupos;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public VotacionPorGrupo login(String email, String psd) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		VotacionPorGrupo u = null;
		Query q = session.createQuery("select u from VotacionPorGrupo u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<VotacionPorGrupo> users = q.getResultList();
		if (users.size() > 0)
			u = (VotacionPorGrupo) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
