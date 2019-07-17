package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ILogDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.model.Log;
import com.bachue.snr.biometrico.admon.persistence.model.Sesion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

	@Override
	public Boolean crearEvento(Log al_log) {
		try {
			EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
			lem_entityManager.persist(al_log);
			lem_entityManager.close();
		}catch (Exception le_e) {
			return false;
		}
		return true;
	}

	@Override
	public int consultarStats(String as_tipo, String as_id) {
		EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
		Query iq_query = lem_entityManager.createQuery(
						"SELECT COUNT(p) FROM Log p WHERE p.evento =:tipo AND p.idEntidad =:id"
		);
		iq_query.setParameter("tipo", as_tipo);
		iq_query.setParameter("id", as_id);
		int ii_conteo = ((Number) iq_query.getSingleResult()).intValue();
		lem_entityManager.close();
		return ii_conteo;
	}
}
