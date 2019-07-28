package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IHuellaDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.model.Huella;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de interface de DAO que permite la gestion de operaciones biometricas.
 *
 */
@Stateless
@Local
public class HuellaDAOImpl implements IHuellaDAO {

	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	@Override
	public Boolean crearHuella(Huella ah_huella) {
		try {
			EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
			lem_entityManager.persist(ah_huella);
			lem_entityManager.close();
		}catch (Exception le_e) {
			return false;
		}
		return true;
	}
}
