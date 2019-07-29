package com.bachue.snr.biometrico.biometrics.util;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.biometrics.Criptografia;
import com.bachue.snr.biometrico.biometrics.Identificador;
import com.bachue.snr.biometrico.biometrics.MotorBiometrico;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Utils {

  static final String SEPARADOR_DE_ARCHIVOS = System.getProperty("file.separator");
  static final String SEPARADOR_DE_CARPETAS = System.getProperty("path.separator");


  private Utils() {}

  /**
   * Devuelve el directorio activo.
   * @return direccctorio activo.
   */
  static String obtenerDirectorioActivo() {
    return System.getProperty("user.dir");
  }


  static boolean esNuloOVacio(String as_value) {
    return as_value == null || "".equals(as_value);
  }

  public static void limpiarDirectorio(String as_carpeta) {
    try {
      FileUtils.cleanDirectory(new File(as_carpeta));
    } catch (Exception ignored){}
  }

  public static boolean crearImagen(HuellaDTO ahd_huella) {
    try {
      byte[] data = Base64.decodeBase64(ahd_huella.getTemplate());
      FileUtils.writeByteArrayToFile(new File("biometria/cache/" + ahd_huella.getUsuarioId() + ".bmp"), data);
      MotorBiometrico.getInstance();
      if (new Identificador().identificar("biometria/cache/" + ahd_huella.getUsuarioId() + ".bmp")) {
        return false;
      }
      FileUtils.writeByteArrayToFile(new File("biometria/huellas/" + ahd_huella.getUsuarioId() + "/" + ahd_huella.getPosicion().consultarPosicion() + ".bmp"), data);
      return true;
    } catch (Exception le_excepcion) {
      return false;
    }
  }
}
