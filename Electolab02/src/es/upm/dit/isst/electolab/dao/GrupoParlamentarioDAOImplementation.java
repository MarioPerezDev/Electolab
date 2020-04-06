package es.upm.dit.isst.electolab.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.GrupoParlamentario;

public class GrupoParlamentarioDAOImplementation implements GrupoParlamentarioDAO {

	  private static  GrupoParlamentarioDAOImplementation instancia = null;
	  private GrupoParlamentarioDAOImplementation() {
	  }

	  public static GrupoParlamentarioDAOImplementation getInstance() {
	    if( null == instancia ) 
	      instancia = new GrupoParlamentarioDAOImplementation();
	    return instancia;
	  }
	  
	@SuppressWarnings("unchecked")
	@Override
	public void create(GrupoParlamentario grupoparlamentario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		session.save(grupoparlamentario);//Crear
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public GrupoParlamentario read(Integer id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		GrupoParlamentario grupoparlamentario = session.get(GrupoParlamentario.class, id);//Read
		session.getTransaction().commit();
		session.close();
		return grupoparlamentario;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void update(GrupoParlamentario grupoparlamentario) {
		Session session = SessionFactoryService.get().openSession();
		session.saveOrUpdate(grupoparlamentario);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void delete(GrupoParlamentario grupoparlamentario) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(grupoparlamentario);
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Collection<GrupoParlamentario> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<GrupoParlamentario> grupoparlamentarios = session.createQuery("from GrupoParlamentario").list();	
		session.getTransaction().commit();
		session.close();
		return grupoparlamentarios;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public GrupoParlamentario login(String email, String psd) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		GrupoParlamentario u = null;
		Query q = session.createQuery("select u from GrupoParlamentario u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<GrupoParlamentario> users = q.getResultList();
		if (users.size() > 0)
			u = (GrupoParlamentario) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
