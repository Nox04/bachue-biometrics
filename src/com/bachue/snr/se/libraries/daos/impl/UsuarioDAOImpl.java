package com.bachue.snr.se.libraries.daos.impl;

import java.util.List;

import com.bachue.snr.se.libraries.daos.IEntityManagerFactory;
import com.bachue.snr.se.libraries.daos.interfaces.IUsuarioDAO;
import com.bachue.snr.se.libraries.shared.persistence.model.Usuario;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Clase que permite la gestion de usuarios
 */
@Stateless
@LocalBean
public class UsuarioDAOImpl implements IUsuarioDAO {

	@EJB
	private IEntityManagerFactory entityFactory;

	@Override
	public Usuario consultarUsuario(Integer idUsuario) {
		EntityManager em = entityFactory.getEntityManager();
		em.getTransaction().begin();
		Usuario user = em.find(Usuario.class, idUsuario);
		em.close();
		return user;
	}
	
	@Override
	public Usuario consultarUsuario(String nombreUsuario) {
		EntityManager em = entityFactory.getEntityManager();
		em.getTransaction().begin();
		String query = "SELECT u FROM Usuario u WHERE u.name =:userName ";
		TypedQuery<Usuario> queryUsuario = em.createQuery(query, Usuario.class);
		queryUsuario.setParameter("userName", nombreUsuario);
		Usuario user = queryUsuario.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return user;
	}
	
	@Override
	public List<Usuario> consultarUsuarios() {
		EntityManager em = entityFactory.getEntityManager();

		em.getTransaction().begin();
		String query = "SELECT u FROM Usuario u ORDER BY u.id ASC";
		List<Usuario> users = em.createQuery(query, Usuario.class).getResultList();		
		em.close();		

		return users;
	}

	@Override
	public Boolean crearUsuario(Usuario user) {
		try {
			EntityManager em = entityFactory.getEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();
		}catch (Exception e) {
			return false;
		}
		return true;
	}

}
