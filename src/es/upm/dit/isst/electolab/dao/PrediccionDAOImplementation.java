package es.upm.dit.isst.electolab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.Prediccion;

public class PrediccionDAOImplementation implements PrediccionDAO {

	private static  PrediccionDAOImplementation instancia = null;
	private PrediccionDAOImplementation() {
	}

	public static PrediccionDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new PrediccionDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Prediccion prediccion){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(prediccion);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Prediccion read(int id){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Prediccion prediccion = session.get(Prediccion.class, id);//Read
		session.getTransaction().commit();
		session.close();
		return prediccion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Prediccion prediccion){
		Session session = SessionFactoryService.get().openSession();
		session.saveOrUpdate(prediccion);
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Prediccion prediccion){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(prediccion);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Prediccion> readAll(){
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Prediccion> prediccions = session.createQuery("from Prediccion").list();	
		session.getTransaction().commit();
		session.close();
		return prediccions;
	}
}
