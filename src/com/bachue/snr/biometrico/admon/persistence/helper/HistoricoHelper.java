package com.bachue.snr.biometrico.admon.persistence.helper;

import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.model.Historico;
import com.bachue.snr.biometrico.biometrics.Criptografia;

public class HistoricoHelper {

  private HistoricoHelper() {}

  /**
   * Metodo que mapea una entidad a su DTO correspondiente.
   * @param ud_entidad que sera convertida a DTO.
   * @return DTO mapeado desde la entidad.
   */
  public static Historico userToHistorico(UsuarioDTO ud_entidad) {

    Historico lh_historico = new Historico();
    lh_historico.setIdUsuario(Criptografia.encrypt(ud_entidad.getIdUsuario()));
    lh_historico.setClaveHash(Criptografia.encrypt(ud_entidad.getClave()));
    lh_historico.setFechaCreacion(ud_entidad.getTime());
    lh_historico.setIpCreacion(ud_entidad.getIp());
    lh_historico.setIdUsuarioCreacion(ud_entidad.getIdUsuarioCreacion());

    return lh_historico;
  }
}
