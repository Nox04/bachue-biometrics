package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ISesionDAO;
import com.bachue.snr.biometrico.admon.persistence.model.Sesion;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de interface de DAO que permite la consulta de sesiones.
 *
 */
@Stateless
@Local
public class SesionDAOImpl implements ISesionDAO {

	@EJB
	private IEntityManagerFactory iiemf_entityFactory;

	@Override
	public Sesion consultarSesion(String as_sesion) {
		EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
		Sesion ls_sesion = lem_entityManager.find(Sesion.class, as_sesion);
		SimpleDateFormat lsdf_format = new SimpleDateFormat("yyyyMMdd");
		if(!lsdf_format.format(ls_sesion.getFechaCreacion()).equals(lsdf_format.format(new Date()))) {
			ls_sesion.setResultado(false);
		}
		lem_entityManager.close();
		return ls_sesion;
	}

	@Override
	public Boolean crearSesion(Sesion as_sesion) {
		try {
			EntityManager lem_entityManager = iiemf_entityFactory.getEntityManager();
			lem_entityManager.persist(as_sesion);
			lem_entityManager.close();
		}catch (Exception le_e) {
			return false;
		}
		return true;
	}

}
