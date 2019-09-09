package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.*;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de logica de operaciones biometricas.
 *
 */
public interface IHuellaBusiness {
  /**
   * Metodo que extrae y envia los datos de la huella al DAO para ser almacenada.
   * @param ahd_huella DTO con la informacion de la huella.
   * @return true si la huella es enrolada con exito.
   */
  Boolean enrolarHuella(HuellaDTO ahd_huella);

  /**
   * Metodo que compara los datos de la huella con los registros biometricos almacenados.
   * @param avd_verificacion DTO con la informacion de la huella.
   * @return true si la huella es procesada con exito. Incluso si el resultado es negativo.
   */
  BooleanSalidaDTO verificarHuella(VerificacionDTO avd_verificacion);

  /**
   * Metodo que borra las huellas del usuario.
   * @param bhd_usuario DTO con la informacion del usuario.
   * @return true si el usuario es registrado con exito.
   */
  StringSalidaDTO borrarHuellas(BorrarHuellasDTO bhd_usuario);

  /**
   * Metodo que crea el megatemplate del usuario.
   * @param ahd_huella DTO con la informacion del usuario.
   * @return true si el usuario es registrado con exito.
   */
  BooleanSalidaDTO crearMegaTemplate(HuellaDTO ahd_huella);
}
