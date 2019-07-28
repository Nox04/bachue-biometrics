package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.VerificacionDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IHuellaDAO;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ILogDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.ISesionDAO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IUsuarioDAO;
import com.bachue.snr.biometrico.admon.persistence.helper.HuellaHelper;
import com.bachue.snr.biometrico.admon.persistence.helper.LogHelper;
import com.bachue.snr.biometrico.admon.persistence.helper.SesionHelper;
import com.bachue.snr.biometrico.biometrics.Enrolador;
import com.bachue.snr.biometrico.biometrics.MotorBiometrico;
import com.bachue.snr.biometrico.biometrics.Identificador;
import com.bachue.snr.biometrico.biometrics.Verificador;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de logica de negocio de operaciones biometricas.
 *
 */
@Stateless(name="HuellaBusiness")
@Local
public class HuellaBusiness implements IHuellaBusiness {
  @EJB
  private IHuellaDAO iihd_huellaDao;

  @EJB
  private ILogDAO iild_logDao;

  @EJB
  private ISesionDAO iisd_sesionDao;

  @EJB
  private IUsuarioDAO iiud_usuarioDao;

  @Override
  public Boolean enrolarHuella(HuellaDTO ahd_huella) {
    MotorBiometrico.getInstance();
    Enrolador le_enrolador = new Enrolador(ahd_huella);
    boolean lb_enrolamiento = le_enrolador.enrolarUsuario();
    if(lb_enrolamiento) {
      iild_logDao.crearEvento(LogHelper.crearLogDeEnrolamiento(ahd_huella, true));
      return iihd_huellaDao.crearHuella(HuellaHelper.toEntity(ahd_huella, iiud_usuarioDao.consultarUsuario(ahd_huella.getUsuarioId())));
    } else {
      iild_logDao.crearEvento(LogHelper.crearLogDeEnrolamiento(ahd_huella, false));
      return false;
    }
  }

  @Override
  public Boolean verificarHuella(VerificacionDTO avd_verificacion) {
    MotorBiometrico.getInstance();
    Verificador lv_verificador = new Verificador();
    boolean lb_resultado = lv_verificador.verificar(avd_verificacion);
    iisd_sesionDao.crearSesion(SesionHelper.createSesion(avd_verificacion, lb_resultado));
    iild_logDao.crearEvento(LogHelper.crearLogDeVerificacion(avd_verificacion, lb_resultado));
    return true;
  }
}
