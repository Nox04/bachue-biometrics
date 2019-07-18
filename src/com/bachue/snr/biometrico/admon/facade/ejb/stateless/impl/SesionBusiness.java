package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ISesionBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.SesionDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ISesionDAO;
import com.bachue.snr.biometrico.admon.persistence.helper.SesionHelper;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de logica de negocio de sesiones.
 *
 */
@Stateless(name="SesionBusiness")
@Local
public class SesionBusiness implements ISesionBusiness {
  @EJB
  private ISesionDAO iisd_sesionDao;

  @Override
  public SesionDTO consultarSesion(String as_sesion) {
    return SesionHelper.toDto(iisd_sesionDao.consultarSesion(as_sesion));
  }
}
