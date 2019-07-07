package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl.IBiometriaLogDAO;
import com.bachue.snr.biometrico.admon.persistence.model.Log;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Implementación de interface de DAO que permite la gestión de logs.
 *
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
