package com.bachue.snr.se.libraries.daos.impl;

import com.bachue.snr.se.libraries.daos.IEntityManagerFactory;
import com.bachue.snr.se.libraries.daos.interfaces.IBiometriaDAO;
import com.bachue.snr.se.libraries.daos.interfaces.IBiometriaLogDAO;
import com.bachue.snr.se.libraries.shared.persistence.model.Log;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Clase que permite la gestion de usuarios
 */
@Stateless
@LocalBean
public class BiometriaLogDAOImpl implements IBiometriaLogDAO {

	@EJB
	private IEntityManagerFactory entityFactory;

	@Override
	public Boolean registrarEvento(Log log) {
		try {
			EntityManager em = entityFactory.getEntityManager();
			em.getTransaction().begin();
			em.persist(log);
			em.getTransaction().commit();
			em.close();
		}catch (Exception e) {
			return false;
		}
		return true;
	}
}
