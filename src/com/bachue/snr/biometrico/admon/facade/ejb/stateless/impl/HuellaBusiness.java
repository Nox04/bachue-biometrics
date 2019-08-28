package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.BorrarHuellasDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.VerificacionDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.*;
import com.bachue.snr.biometrico.admon.persistence.helper.HuellaHelper;
import com.bachue.snr.biometrico.admon.persistence.helper.LogHelper;
import com.bachue.snr.biometrico.admon.persistence.helper.SesionHelper;
import com.bachue.snr.biometrico.admon.persistence.model.Constante;
import com.bachue.snr.biometrico.biometrics.Criptografia;
import com.bachue.snr.biometrico.biometrics.Enrolador;
import com.bachue.snr.biometrico.biometrics.MotorBiometrico;
import com.bachue.snr.biometrico.biometrics.Verificador;
import com.bachue.snr.biometrico.biometrics.util.Utils;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

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

  @EJB
  private IConstanteDAO iicd_constanteDao;

  private String is_matchingThreshold = "40";

  @Override
  public Boolean enrolarHuella(HuellaDTO ahd_huella) {
    if(!Utils.crearImagen(ahd_huella)) {
      return false;
    }
    return iihd_huellaDao.crearHuella(HuellaHelper.toEntity(ahd_huella, iiud_usuarioDao.consultarUsuario(ahd_huella.getUsuarioId())));
  }

  @Override
  public Boolean verificarHuella(VerificacionDTO avd_verificacion) {
    leerConstantes();
    Verificador lv_verificador = new Verificador();
    boolean lb_resultado = lv_verificador.verificar(avd_verificacion, iihd_huellaDao.obtenerHuellas(avd_verificacion.getUsuarioId()));
    iisd_sesionDao.crearSesion(SesionHelper.createSesion(avd_verificacion, lb_resultado));
    iild_logDao.crearEvento(LogHelper.crearLogDeVerificacion(avd_verificacion, lb_resultado));
    return true;
  }

  @Override
  public String borrarHuellas(BorrarHuellasDTO bhd_usuario) {
    leerConstantes();
    Enrolador le_enrolador = new Enrolador(null);
    le_enrolador.eliminarHuellas(Criptografia.encrypt(bhd_usuario.getIdUsuario()));
    iihd_huellaDao.borrarHuellas(Criptografia.encrypt(bhd_usuario.getIdUsuario()));
    iild_logDao.crearEvento(LogHelper.crearLogDeBorrado(bhd_usuario));
    return String.valueOf(true);
  }

  @Override
  public Boolean crearMegaTemplate(HuellaDTO ahd_huella) {
    leerConstantes();
    Enrolador le_enrolador = new Enrolador(ahd_huella);
    boolean lb_enrolamiento = le_enrolador.enrolarUsuario(iihd_huellaDao.obtenerHuellas(ahd_huella.getUsuarioId()));
    iild_logDao.crearEvento(LogHelper.crearLogDeEnrolamiento(ahd_huella, lb_enrolamiento));
    return lb_enrolamiento;
  }

  private void leerConstantes() {
    List<Constante> llc_constantes = iicd_constanteDao.obtenerConstantes();
    llc_constantes.forEach(e -> {
      if(e.getIdConstante().equals("MATCHING_THRESHOLD_BIOMETRIA")) {
        is_matchingThreshold = e.getCaracter();
      }
    });
    MotorBiometrico.getInstance();
    MotorBiometrico.getInstance().getCliente().setMatchingThreshold(Integer.parseInt(is_matchingThreshold));
  }
}
