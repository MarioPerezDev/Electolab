package es.upm.dit.isst.electolab.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.Diputado;

public class DiputadoDAOImplementation implements DiputadoDAO {

	  private static  DiputadoDAOImplementation instancia = null;
	  private DiputadoDAOImplementation() {
	  }

	  public static DiputadoDAOImplementation getInstance() {
	    if( null == instancia ) 
	      instancia = new DiputadoDAOImplementation();
	    return instancia;
	  }
	  
	@SuppressWarnings("unchecked")
	@Override
	public void create(Diputado diputado) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		session.save(diputado);//Crear
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Diputado read(Integer id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		Diputado diputado = session.get(Diputado.class, id);//Read
		session.getTransaction().commit();
		session.close();
		return diputado;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void update(Diputado diputado) {
		Session session = SessionFactoryService.get().openSession();
		session.saveOrUpdate(diputado);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Diputado diputado) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(diputado);
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Diputado> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Diputado> diputados = session.createQuery("from Diputado").list();	
		session.getTransaction().commit();
		session.close();
		return diputados;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Diputado login(String email, String psd) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Diputado u = null;
		Query q = session.createQuery("select u from Diputado u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<Diputado> users = q.getResultList();
		if (users.size() > 0)
			u = (Diputado) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
