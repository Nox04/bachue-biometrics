package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.enums.SalidasEnum;
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
    try {
      return SesionHelper.toDto(iisd_sesionDao.consultarSesion(as_sesion));
    } catch (Exception le_exception) {
      SesionDTO lsd_sesion = new SesionDTO();
      lsd_sesion.setCodigo(SalidasEnum.RECURSO_NO_ENCONTRADO.consultarCodigo());
      lsd_sesion.setMensaje(SalidasEnum.RECURSO_NO_ENCONTRADO.consultarMensaje());
    }
  }
}
