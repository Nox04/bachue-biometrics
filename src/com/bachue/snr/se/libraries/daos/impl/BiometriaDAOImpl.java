package com.bachue.snr.se.libraries.daos.impl;

import com.bachue.snr.se.libraries.daos.IEntityManagerFactory;
import com.bachue.snr.se.libraries.daos.interfaces.IBiometriaDAO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Clase que permite la gestion de usuarios
 */
@Stateless
@LocalBean
public class BiometriaDAOImpl implements IBiometriaDAO {

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
}