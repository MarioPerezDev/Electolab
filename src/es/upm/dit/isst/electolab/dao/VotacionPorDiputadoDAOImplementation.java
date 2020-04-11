package es.upm.dit.isst.electolab.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.VotacionPorDiputado;

public class VotacionPorDiputadoDAOImplementation implements VotacionPorDiputadoDAO {

	  private static  VotacionPorDiputadoDAOImplementation instancia = null;
	  private VotacionPorDiputadoDAOImplementation() {
	  }

	  public static VotacionPorDiputadoDAOImplementation getInstance() {
	    if( null == instancia ) 
	      instancia = new VotacionPorDiputadoDAOImplementation();
	    return instancia;
	  }
	  
	@SuppressWarnings("unchecked")
	@Override
	public void create(VotacionPorDiputado votacionpordiputado) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		session.save(votacionpordiputado);//Crear
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public VotacionPorDiputado read(Integer id) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		//Operaciones
		VotacionPorDiputado votacionpordiputado = session.get(VotacionPorDiputado.class, id);//Read
		session.getTransaction().commit();
		session.close();
		return votacionpordiputado;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void update(VotacionPorDiputado votacionpordiputado) {
		Session session = SessionFactoryService.get().openSession();
		session.saveOrUpdate(votacionpordiputado);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public void delete(VotacionPorDiputado votacionpordiputado) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(votacionpordiputado);
		session.getTransaction().commit();
		session.close();
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public Collection<VotacionPorDiputado> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<VotacionPorDiputado> votacionpordiputados = session.createQuery("from VotacionPorDiputado").list();	
		session.getTransaction().commit();
		session.close();
		return votacionpordiputados;
	}
	  
	@SuppressWarnings("unchecked")
	@Override
	public VotacionPorDiputado login(String email, String psd) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		VotacionPorDiputado u = null;
		Query q = session.createQuery("select u from VotacionPorDiputado u where u.email = :email and u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<VotacionPorDiputado> users = q.getResultList();
		if (users.size() > 0)
			u = (VotacionPorDiputado) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
