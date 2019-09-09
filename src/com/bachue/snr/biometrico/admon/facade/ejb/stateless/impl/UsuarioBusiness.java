package com.bachue.snr.biometrico.admon.facade.ejb.stateless.impl;

import com.bachue.snr.biometrico.admon.enums.RespuestaUsuarioEnum;
import com.bachue.snr.biometrico.admon.enums.SalidasEnum;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IUsuarioBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.BooleanSalidaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.ClaveDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.StringSalidaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless.*;
import com.bachue.snr.biometrico.admon.persistence.helper.*;
import com.bachue.snr.biometrico.admon.persistence.model.Constante;
import com.bachue.snr.biometrico.admon.persistence.model.Historico;
import com.bachue.snr.biometrico.admon.persistence.model.Usuario;
import com.bachue.snr.biometrico.biometrics.Criptografia;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Implementacion de logica de negocio de usuario.
 *
 */
@Stateless(name="UsuarioBusiness")
@Local
public class UsuarioBusiness implements IUsuarioBusiness {
  @EJB
  private IUsuarioDAO iiud_usuarioDao;

  @EJB
  private IUsuarioBachueDAO iiud_usuarioBachueDao;

  @EJB
  private IHistoricoDAO iihd_historicoDao;

  @EJB
  private IHuellaDAO iihd_huellaDao;

  @EJB
  private ISesionDAO iisd_sesionDao;

  @EJB
  private ILogDAO iild_logDao;

  @EJB
  private IConstanteDAO iicd_constanteDao;

  private String is_clavePatron = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[-*@#$%^&+=])(?=\\S+$).{8,}";
  private String is_claveMinimo = "8";
  private String is_claveMaximo = "32";

  @Override
  public StringSalidaDTO crearUsuario(UsuarioDTO aud_usuario) {
    StringSalidaDTO lssd_salida = new StringSalidaDTO();
    lssd_salida.setCodigo(SalidasEnum.RECURSO_EXITOSO.consultarCodigo());
    lssd_salida.setMensaje(SalidasEnum.RECURSO_EXITOSO.consultarMensaje());

    try {
      leerConstantes();
      String ls_resultado = ValidadorHelper.validarClave(aud_usuario.getClave(), is_clavePatron, is_claveMinimo, is_claveMaximo);
      if (ls_resultado.equals("Validado exitosamente")) {
        iiud_usuarioDao.crearUsuario(UsuarioHelper.toEntity(aud_usuario));
        lssd_salida.setResultado(String.valueOf(iihd_historicoDao.crearHistorico(HistoricoHelper.userToHistorico(aud_usuario))));
      } else {
        lssd_salida.setResultado(ls_resultado);
      }
      return lssd_salida;
    } catch (Exception le_exception) {
      lssd_salida.setCodigo(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarCodigo());
      lssd_salida.setMensaje(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarMensaje());

      return lssd_salida;
    }
  }

  @Override
  public StringSalidaDTO actualizarClave(UsuarioDTO aud_usuario) {
    StringSalidaDTO lssd_salida = new StringSalidaDTO();
    lssd_salida.setCodigo(SalidasEnum.RECURSO_EXITOSO.consultarCodigo());
    lssd_salida.setMensaje(SalidasEnum.RECURSO_EXITOSO.consultarMensaje());

    try {
      leerConstantes();
      String ls_resultado = ValidadorHelper.validarClave(aud_usuario.getClave(), is_clavePatron, is_claveMinimo, is_claveMaximo);
      if(ls_resultado.equals("Validado exitosamente")) {
        Usuario lu_usuarioActual = iiud_usuarioDao.consultarUsuario(Criptografia.encrypt(aud_usuario.getIdUsuario()));
        if(lu_usuarioActual.getClaveHash().equals(Criptografia.encrypt(aud_usuario.getClave()))) {
          lssd_salida.setResultado("La clave ingresada debe ser diferente a la actual");
          return lssd_salida;
        } else {
          List<Historico> llh_historico = iihd_historicoDao.consultarUltimasCincoClaves(Criptografia.encrypt(aud_usuario.getIdUsuario()));
          boolean lb_claveUsada = false;

          for(Historico claveActual : llh_historico) {
            if(Objects.equals(Criptografia.encrypt(aud_usuario.getClave()), claveActual.getClaveHash())) {
              lb_claveUsada = true;
            }
          }

          if(lb_claveUsada) {
            lssd_salida.setResultado("La clave ingresada debe ser diferente a las últimas cinco utilizadas");
            return lssd_salida;
          } else {
            iild_logDao.crearEvento(LogHelper.crearLogDeActualizacionDeClave(aud_usuario));
            iihd_historicoDao.crearHistorico(HistoricoHelper.userToHistorico(aud_usuario));

            lssd_salida.setResultado(String.valueOf(iiud_usuarioDao.actualizarClave(UsuarioHelper.usuarioConClave(aud_usuario))));
            return lssd_salida;
          }
        }
      } else {
        lssd_salida.setResultado(ls_resultado);
        return lssd_salida;
      }
    } catch (Exception le_exception) {
      lssd_salida.setCodigo(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarCodigo());
      lssd_salida.setMensaje(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarMensaje());

      return lssd_salida;
    }
  }

  @Override
  public StringSalidaDTO obtenerUsuario(String as_id) {
    StringSalidaDTO lssd_salida = new StringSalidaDTO();
    lssd_salida.setCodigo(SalidasEnum.RECURSO_EXITOSO.consultarCodigo());
    lssd_salida.setMensaje(SalidasEnum.RECURSO_EXITOSO.consultarMensaje());

    try {
      boolean lb_usuarioExiste = iiud_usuarioDao.consultarUsuario(Criptografia.encrypt(as_id)) != null;
      if(lb_usuarioExiste) {
        int li_cuenta = iihd_huellaDao.contarHuellas(Criptografia.encrypt(as_id));
        if(li_cuenta > 0) {
          lssd_salida.setResultado(RespuestaUsuarioEnum.USUARIO_EXISTE.toString());
          return lssd_salida;
        } else {
          lssd_salida.setCodigo(SalidasEnum.RECURSO_NO_VALIDO.consultarCodigo());
          lssd_salida.setMensaje(SalidasEnum.RECURSO_NO_VALIDO.consultarMensaje());
          lssd_salida.setResultado(RespuestaUsuarioEnum.USUARIO_NO_TIENE_HUELLAS.toString());
          return lssd_salida;
        }
      } else {
        lssd_salida.setCodigo(SalidasEnum.RECURSO_NO_ENCONTRADO.consultarCodigo());
        lssd_salida.setMensaje(SalidasEnum.RECURSO_NO_ENCONTRADO.consultarMensaje());
        lssd_salida.setResultado(RespuestaUsuarioEnum.USUARIO_NO_EXISTE.toString());
        return lssd_salida;
      }
    } catch (Exception le_exception) {
      lssd_salida.setCodigo(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarCodigo());
      lssd_salida.setMensaje(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarMensaje());

      return lssd_salida;
    }
  }

  @Override
  public BooleanSalidaDTO verificarUsuario(ClaveDTO acd_clave) {
    BooleanSalidaDTO lbsd_salida = new BooleanSalidaDTO();
    lbsd_salida.setCodigo(SalidasEnum.RECURSO_EXITOSO.consultarCodigo());
    lbsd_salida.setMensaje(SalidasEnum.RECURSO_EXITOSO.consultarMensaje());

    try {
      Usuario lu_usuario = iiud_usuarioDao.consultarUsuario(Criptografia.encrypt(acd_clave.getIdUsuario()));
      boolean lb_resultado = (
              lu_usuario.getClaveHash().equals(Criptografia.encrypt(acd_clave.getClave())) &&
                      lu_usuario.getFechaVencimiento().after(new Date()) &&
                      lu_usuario.getClaveActiva() == '1'
      );
      iisd_sesionDao.crearSesion(SesionHelper.crearSesionConClave(acd_clave, lb_resultado));
      iild_logDao.crearEvento(LogHelper.crearLogDeVerificacionConClave(acd_clave, lb_resultado));
      lbsd_salida.setResultado(true);

      return lbsd_salida;
    } catch (Exception le_exception) {
      lbsd_salida.setCodigo(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarCodigo());
      lbsd_salida.setMensaje(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarMensaje());
      lbsd_salida.setResultado(false);

      return lbsd_salida;
    }
  }

  @Override
  public StringSalidaDTO obtenerTipoSegundoFactor(String as_id) {
    StringSalidaDTO lssd_salida = new StringSalidaDTO();
    lssd_salida.setCodigo(SalidasEnum.RECURSO_EXITOSO.consultarCodigo());
    lssd_salida.setMensaje(SalidasEnum.RECURSO_EXITOSO.consultarMensaje());

    try {
      lssd_salida.setResultado(iiud_usuarioBachueDao.obtenerSegundoFactor(as_id));
      return lssd_salida;
    } catch (Exception le_exception) {
      lssd_salida.setCodigo(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarCodigo());
      lssd_salida.setMensaje(SalidasEnum.EXCEPCION_NO_CONTROLADA.consultarMensaje());

      return lssd_salida;
    }
  }

  private void leerConstantes() {
    List<Constante> llc_constantes = iicd_constanteDao.obtenerConstantes();
    llc_constantes.forEach(e -> {
      switch (e.getIdConstante()) {
        case "CARACTERES_MINIMOS_CLAVE_SEGUNDO_FACTOR":
          is_claveMinimo = e.getCaracter();
          break;
        case "CARACTERES_MAXIMOS_CLAVE_SEGUNDO_FACTOR":
          is_claveMaximo = e.getCaracter();
          break;
        case "PATRON_CLAVE_SEGUNDO_FACTOR":
          is_clavePatron = e.getCaracter();
          break;
      }
    });
  }
}
