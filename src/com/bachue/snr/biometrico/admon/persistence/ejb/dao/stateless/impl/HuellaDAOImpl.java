package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IHuellaDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IEntityManagerFactory;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

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
	public Boolean consultarHuella(Integer ai_idUsuario) {
		return true;
	}
}
