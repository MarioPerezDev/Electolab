package es.upm.dit.isst.electolab.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.Partido;

public class PartidoDAOImplementation implements PartidoDAO {

	  private static  PartidoDAOImplementation instancia = null;
	  private PartidoDAOImplementation() {
	  }

	  public static PartidoDAOImplementation getInstance() {
	    if( null == instancia ) 
	      instancia = new PartidoDAOImplementation();
	    return instancia;
	  }
	  
	@SuppressWarnings("unchecked")
	@Override
	public void create(Partido partido) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		session.save(partido);//Crear
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Partido read(Integer id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		Partido partido = session.get(Partido.class, id);//Read
		session.getTransaction().commit();
		session.close();
		return partido;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void update(Partido partido) {
		Session session = SessionFactoryService.get().openSession();
		session.saveOrUpdate(partido);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Partido partido) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(partido);
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Partido> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Partido> partidos = session.createQuery("from Partido").list();	
		session.getTransaction().commit();
		session.close();
		return partidos;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Partido login(String email, String psd) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Partido u = null;
		Query q = session.createQuery("select u from Partido u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<Partido> users = q.getResultList();
		if (users.size() > 0)
			u = (Partido) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
