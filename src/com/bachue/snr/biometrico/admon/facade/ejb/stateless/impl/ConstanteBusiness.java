package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.enums.SalidasEnum;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IConstanteBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.ConstantesSalidaDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.*;
import com.bachue.snr.biometrico.admon.persistence.model.Constante;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de logica de negocio de usuario.
 *
 */
@Stateless(name="ConstanteBusiness")
@Local
public class ConstanteBusiness implements IConstanteBusiness {
  @EJB
  private IConstanteDAO iicd_constanteDao;


  @Override
  public ConstantesSalidaDTO obtenerConstantes() {
    ConstantesSalidaDTO lcsd_constantes = new ConstantesSalidaDTO();
    lcsd_constantes.setCodigo(SalidasEnum.RECURSO_EXITOSO.consultarCodigo());
    lcsd_constantes.setMensaje(SalidasEnum.RECURSO_EXITOSO.consultarMensaje());

    try {
      lcsd_constantes.setConstantes(new ArrayList<>(iicd_constanteDao.obtenerConstantes()));
      return lcsd_constantes;
    } catch (Exception le_exception) {
      lcsd_constantes.setCodigo(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarCodigo());
      lcsd_constantes.setMensaje(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarMensaje());
      return lcsd_constantes;
    }
  }
}
