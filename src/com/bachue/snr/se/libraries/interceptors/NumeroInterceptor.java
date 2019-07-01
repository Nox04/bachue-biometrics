package com.bachue.snr.se.libraries.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import com.bachue.snr.se.libraries.shared.business.interfaces.INumeroBusiness;

public class NumeroInterceptor {

	final static Logger logger = Logger.getLogger(INumeroBusiness.class);
	
	@AroundInvoke
	public void intercept(InvocationContext context) throws Exception {		
		logger.debug("Acceso "+context.getMethod().getName());
	}

}
