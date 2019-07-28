package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.IHuellaDAO;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
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

  @Override
  public Boolean enrolarHuella(HuellaDTO ahd_huella) {
    MotorBiometrico.getInstance();
    Enrolador le_enrolador = new Enrolador(ahd_huella);
    boolean lb_enrolamiento = le_enrolador.enrolarUsuario();
    //Guardar huella en la tabla
    //Identificar antes de enrolar
    return lb_enrolamiento;
  }

  @Override
  public Boolean verificarHuella(HuellaDTO ahd_huella) {
    MotorBiometrico.getInstance();
    Verificador lv_verificador = new Verificador();
    //Logs de operaciones
    return lv_verificador.verificar(ahd_huella);
  }
}
