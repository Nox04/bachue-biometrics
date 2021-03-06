package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.enums.SalidasEnum;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.BooleanSalidaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.EstadisticasSalidaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ILogDAO;
import com.bachue.snr.biometrico.admon.persistence.helper.LogHelper;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.NoSuchElementException;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de logica de negocio de logs.
 *
 */
@Stateless(name="LogBusiness")
@Local
public class LogBusiness implements ILogBusiness {
  @EJB
  private ILogDAO iild_logDao;

  @Override
  public BooleanSalidaDTO registrarEvento(LogDTO ald_log) {
    BooleanSalidaDTO lbsd_salida = new BooleanSalidaDTO();
    lbsd_salida.setCodigo(SalidasEnum.RECURSO_EXITOSO.consultarCodigo());
    lbsd_salida.setMensaje(SalidasEnum.RECURSO_EXITOSO.consultarMensaje());
    try {
      lbsd_salida.setResultado(iild_logDao.crearEvento(LogHelper.toEntity(ald_log)));
      return lbsd_salida;
    } catch (Exception le_exception) {
      lbsd_salida.setCodigo(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarCodigo());
      lbsd_salida.setMensaje(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarMensaje());
      return lbsd_salida;
    }
  }

  @Override
  public EstadisticasSalidaDTO consultarStats(String as_tipo, String as_id) {
    EstadisticasSalidaDTO lesd_estadisticas = new EstadisticasSalidaDTO();
    lesd_estadisticas.setCodigo(SalidasEnum.RECURSO_EXITOSO.consultarCodigo());
    lesd_estadisticas.setMensaje(SalidasEnum.RECURSO_EXITOSO.consultarMensaje());
    try {
      int li_contador = iild_logDao.consultarStats(as_tipo, as_id);
      if(li_contador > 0) {
        lesd_estadisticas.setContador(li_contador);
      } else {
        throw new NoSuchElementException();
      }
      return lesd_estadisticas;
    } catch (Exception le_exception) {
      lesd_estadisticas.setContador(0);
      lesd_estadisticas.setCodigo(SalidasEnum.RECURSO_NO_ENCONTRADO.consultarCodigo());
      lesd_estadisticas.setMensaje(SalidasEnum.RECURSO_NO_ENCONTRADO.consultarMensaje());
      return lesd_estadisticas;
    }
  }
}
