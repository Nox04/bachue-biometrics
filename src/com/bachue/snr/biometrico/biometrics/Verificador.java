package com.bachue.snr.biometrico.biometrics;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.neurotec.biometrics.*;
import com.neurotec.io.NBuffer;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.EnumSet;

public class Verificador {

  public boolean verificar(HuellaDTO ahd_huella) {
    NSubject lns_subjectCandidate = new NSubject();
    NSubject lns_subjectProbe = new NSubject();

    try {
      crearCarpeta();
      byte[] data = Base64.decodeBase64(ahd_huella.getTemplate());
      FileUtils.writeByteArrayToFile(new File("biometria/cache/" + ahd_huella.getUsuarioId()+ ".bmp"), data);
      NBuffer lnb_bufferCandidate = Extractor.crearTemplate("biometria/cache/" + ahd_huella.getUsuarioId()+ ".bmp");
      NBuffer lnb_bufferProbe = Extractor.crearTemplate("biometria/huellas/" + ahd_huella.getUsuarioId()+ ".bmp");
      if(lnb_bufferProbe != null && lnb_bufferCandidate != null){
        lns_subjectCandidate.setTemplateBuffer(lnb_bufferCandidate);
        lns_subjectProbe.setTemplateBuffer(lnb_bufferProbe);
      } else {
        return false;
      }

    } catch (Exception le_excepcion) {
      le_excepcion.printStackTrace();
      return false;
    }
    MotorBiometrico.getInstance().getCliente().setFingersMatchingSpeed(NMatchingSpeed.LOW);
    NBiometricStatus lnbs_status = MotorBiometrico.getInstance().getCliente().verify(lns_subjectProbe, lns_subjectCandidate);
    if (lnbs_status == NBiometricStatus.OK || lnbs_status == NBiometricStatus.MATCH_NOT_FOUND) {
      return lnbs_status == NBiometricStatus.OK;
    } else {
      return false;
    }
  }
  private void crearCarpeta() {
    File lf_carpeta = new File("biometria/cache");
    if (!lf_carpeta.exists()) lf_carpeta.mkdirs();
  }
}
