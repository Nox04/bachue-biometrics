package com.bachue.snr.biometrico.biometrics;

import com.bachue.snr.biometrico.admon.persistence.dto.VerificacionDTO;
import com.neurotec.biometrics.NBiometricStatus;
import com.neurotec.biometrics.NMatchingSpeed;
import com.neurotec.biometrics.NSubject;
import com.neurotec.io.NBuffer;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Verificador {

  public boolean verificar(VerificacionDTO avd_verificacion) {
    NSubject lns_subjectCandidate = new NSubject();
    NSubject lns_subjectProbe = new NSubject();

    try {
      crearCarpeta();
      byte[] data = Base64.decodeBase64(avd_verificacion.getTemplate());
      FileUtils.writeByteArrayToFile(new File("biometria/cache/" + Criptografia.decrypt(avd_verificacion.getUsuarioId())+ ".bmp"), data);
      NBuffer lnb_bufferCandidate = Extractor.crearTemplate("biometria/cache/" + Criptografia.decrypt(avd_verificacion.getUsuarioId())+ ".bmp");
      for (File lf_file: FileUtils.listFiles(new File("biometria/huellas/" + Criptografia.decrypt(avd_verificacion.getUsuarioId())), new String[] { "bmp" }, false)) {
        NBuffer lnb_bufferProbe = Extractor.crearTemplate(lf_file.getAbsolutePath());
        if(lnb_bufferProbe != null && lnb_bufferCandidate != null){
          lns_subjectCandidate.setTemplateBuffer(lnb_bufferCandidate);
          lns_subjectProbe.setTemplateBuffer(lnb_bufferProbe);

          MotorBiometrico.getInstance().getCliente().setFingersMatchingSpeed(NMatchingSpeed.LOW);
          NBiometricStatus lnbs_status = MotorBiometrico.getInstance().getCliente().verify(lns_subjectProbe, lns_subjectCandidate);
          if (lnbs_status == NBiometricStatus.OK) {
            return true;
          }
        } else {
          return false;
        }
      }
      return false;
    } catch (Exception le_excepcion) {
      le_excepcion.printStackTrace();
      return false;
    }
  }
  private void crearCarpeta() {
    File lf_carpeta = new File("biometria/cache");
    if (!lf_carpeta.exists()) lf_carpeta.mkdirs();
  }
}
