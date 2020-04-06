package es.upm.dit.isst.electolab.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.Ley;

public class LeyDAOImplementation implements LeyDAO {

	  private static  LeyDAOImplementation instancia = null;
	  private LeyDAOImplementation() {
	  }

	  public static LeyDAOImplementation getInstance() {
	    if( null == instancia ) 
	      instancia = new LeyDAOImplementation();
	    return instancia;
	  }
	  
	@SuppressWarnings("unchecked")
	@Override
	public void create(Ley ley) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		session.save(ley);//Crear
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Ley read(Integer id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		Ley ley = session.get(Ley.class, id);//Read
		session.getTransaction().commit();
		session.close();
		return ley;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void update(Ley ley) {
		Session session = SessionFactoryService.get().openSession();
		session.saveOrUpdate(ley);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Ley ley) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(ley);
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Ley> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Ley> leys = session.createQuery("from Ley").list();	
		session.getTransaction().commit();
		session.close();
		return leys;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Ley login(String email, String psd) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Ley u = null;
		Query q = session.createQuery("select u from Ley u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<Ley> users = q.getResultList();
		if (users.size() > 0)
			u = (Ley) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
