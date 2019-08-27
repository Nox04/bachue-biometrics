package com.bachue.snr.biometrico.admon.persistence.helper;

import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.model.Historico;
import com.bachue.snr.biometrico.biometrics.Criptografia;

public class HistoricoHelper {

  private HistoricoHelper() {}

  /**
   * Metodo que mapea una entidad a su DTO correspondiente.
   * @param ud_usuarioDTO que sera convertida a entidad.
   * @return entidad historico.
   */
  public static Historico userToHistorico(UsuarioDTO ud_usuarioDTO) {

    Historico lh_historico = new Historico();
    lh_historico.setIdUsuario(Criptografia.encrypt(ud_usuarioDTO.getIdUsuario()));
    lh_historico.setClaveHash(Criptografia.encrypt(ud_usuarioDTO.getClave()));
    lh_historico.setFechaCreacion(ud_usuarioDTO.getTime());
    lh_historico.setIpCreacion(ud_usuarioDTO.getIp());
    lh_historico.setIdUsuarioCreacion(ud_usuarioDTO.getIdUsuarioCreacion());

    return lh_historico;
  }
}
