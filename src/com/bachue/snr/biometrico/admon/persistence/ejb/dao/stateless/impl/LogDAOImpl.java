package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ILogDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.model.Log;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementación de interface de DAO que permite la gestión de logs.
 *
 */
@Stateless
@LocalBean
public class LogDAOImpl implements ILogDAO {

	@EJB
	private IEntityManagerFactory iiemf_entityFactory;
	
	@PersistenceContext
	private EntityManager iem_entityManager;

	@Override
	public Boolean crearEvento(Log al_log) {
		try {
			iem_entityManager = iiemf_entityFactory.getEntityManager();
			iem_entityManager.persist(al_log);
			iem_entityManager.close();
		}catch (Exception le_e) {
			return false;
		}
		return true;
	}
}
