package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ILogDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ISesionDAO;
import com.bachue.snr.biometrico.admon.persistence.model.Log;
import com.bachue.snr.biometrico.admon.persistence.model.Sesion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementación de interface de DAO que permite la consulta de sesiones.
 *
 */
@Stateless
@LocalBean
public class SesionDAOImpl implements ISesionDAO {

	@EJB
	private IEntityManagerFactory iiemf_entityFactory;
	
	@PersistenceContext
	private EntityManager iem_entityManager;

	@Override
	public Sesion consultarSesion(String as_sesion) {
		iem_entityManager = iiemf_entityFactory.getEntityManager();
		String ls_query = "SELECT u FROM Sesion u WHERE u.sesion =:sesion ";
		TypedQuery<Sesion> itq_querySesion = iem_entityManager.createQuery(ls_query, Sesion.class);
		itq_querySesion.setParameter("sesion", as_sesion);
		Sesion is_sesion = itq_querySesion.getSingleResult();
		iem_entityManager.close();
		return is_sesion;
	}
}
