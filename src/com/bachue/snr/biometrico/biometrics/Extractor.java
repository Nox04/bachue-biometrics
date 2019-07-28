package com.bachue.snr.biometrico.biometrics;

import com.neurotec.biometrics.NBiometricStatus;
import com.neurotec.biometrics.NFinger;
import com.neurotec.biometrics.NSubject;
import com.neurotec.images.NImage;
import com.neurotec.io.NBuffer;

import java.io.IOException;

class Extractor {
  static NBuffer crearTemplate(String as_fileName) throws IOException {
    NImage lni_imagen = NImage.fromFile(as_fileName);

    if (lni_imagen.getVertResolution() < 450) {
      lni_imagen.setVertResolution(500);
    }
    if (lni_imagen.getHorzResolution() < 450) {
      lni_imagen.setHorzResolution(500);
    }

    NFinger lnf_dedo = new NFinger();
    lnf_dedo.setImage(lni_imagen);

    NSubject lns_subject = new NSubject();
    lns_subject.getFingers().add(lnf_dedo);


    NBiometricStatus lnbs_estado = MotorBiometrico.getInstance().getCliente().createTemplate(lns_subject);
    NBuffer lnb_buffer = null;

    if (lnbs_estado == NBiometricStatus.OK) {
      lnb_buffer = lns_subject.getTemplateBuffer();
      lns_subject.dispose();
      lnf_dedo.dispose();
      lni_imagen.dispose();
    }

    return lnb_buffer;
  }
}
