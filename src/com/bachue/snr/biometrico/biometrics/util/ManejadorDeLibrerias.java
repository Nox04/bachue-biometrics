package com.bachue.snr.biometrico.biometrics.util;

import com.sun.jna.Platform;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.lang.reflect.Field;

public class ManejadorDeLibrerias {
  // ===========================================================
  // Private static fields
  // ===========================================================

  private static final String WIN32_X86 = "Win32_x86";
  private static final String WIN64_X64 = "Win64_x64";
  private static final String LINUX_X86 = "Linux_x86";
  private static final String LINUX_X86_64 = "Linux_x86_64";
  private static final String ARM_32 = "Linux_armhf";
  private static final String ARM_64 = "Linux_arm64";
  private static final String MAC_OS = "/Library/Frameworks/";

  /**
   * Cargar librerias de Neurotechnology.
   */
  public static void inicializarLibrerias() {
    String ls_libraryPath = obtenerRutaDelSistema();
    String ls_jnaLibraryPath = System.getProperty("jna.library.path");
    if (Utils.esNuloOVacio(ls_jnaLibraryPath)) {
      System.setProperty("jna.library.path", ls_libraryPath);
    } else {
      System.setProperty("jna.library.path",
              String.format("%s%s%s", ls_jnaLibraryPath, Utils.SEPARADOR_DE_CARPETAS, ls_libraryPath));
    }
    System.setProperty("java.library.path",
            String.format("%s%s%s", System.getProperty("java.library.path"),
                    Utils.SEPARADOR_DE_CARPETAS, ls_libraryPath));

    try {
      Field lf_fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
      lf_fieldSysPath.setAccessible(true);
      lf_fieldSysPath.set(null, null);
    } catch (Exception le_excepcion) {
      le_excepcion.printStackTrace();
    }
  }

  public static String obtenerRutaDelSistema() {
    String ls_dominio = "biometria";
    try {
      Context lc_env = (Context) new InitialContext().lookup("java:comp/env");
      ls_dominio = (String)lc_env.lookup("dominio");
    } catch (NamingException lne_excepcion) {
      lne_excepcion.printStackTrace();
    }

    StringBuilder lsb_path = new StringBuilder();
    int li_index = Utils.obtenerDirectorioActivo().lastIndexOf(Utils.SEPARADOR_DE_ARCHIVOS);
    if (li_index == -1) {
      return null;
    }
    String ls_part = Utils.obtenerDirectorioActivo().substring(0, li_index);
    if (Platform.isWindows()) {
      if (ls_part.endsWith("Bin")) {
        lsb_path.append(ls_part);
        lsb_path.append(Utils.SEPARADOR_DE_ARCHIVOS);
        lsb_path.append(Platform.is64Bit() ? WIN64_X64 : WIN32_X86);
      } else {
        lsb_path.append(ls_part).append(Utils.SEPARADOR_DE_ARCHIVOS).append(ls_dominio).append(Utils.SEPARADOR_DE_ARCHIVOS).append("bin");
        lsb_path.append(Utils.SEPARADOR_DE_ARCHIVOS);
        lsb_path.append(Platform.is64Bit() ? WIN64_X64 : WIN32_X86);
      }
    } else if (Platform.isLinux()) {
      li_index = ls_part.lastIndexOf(Utils.SEPARADOR_DE_ARCHIVOS);
      if (li_index == -1) {
        return null;
      }
      ls_part = ls_part.substring(0, li_index);
      lsb_path.append(ls_part);
      lsb_path.append(Utils.SEPARADOR_DE_ARCHIVOS);
      lsb_path.append("Lib");
      lsb_path.append(Utils.SEPARADOR_DE_ARCHIVOS);
      if (Platform.isARM()) {
        lsb_path.append(Platform.is64Bit() ? ARM_64 : ARM_32);
      } else {
        lsb_path.append(Platform.is64Bit() ? LINUX_X86_64 : LINUX_X86);
      }
    } else if (Platform.isMac()) {
      lsb_path.append(MAC_OS);
    }
    return lsb_path.toString();
  }
}
