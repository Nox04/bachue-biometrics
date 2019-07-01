package com.bachue.snr.se.libraries.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bachue.snr.se.libraries.enums.RolesEnum;

public class UsuarioUtilidades {

	public static String consultarRole(UserDetails usuario) {
		Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();
		RolesEnum role = null;
		for (GrantedAuthority grantedAuthority : authorities) {
			role = RolesEnum.valueOf((grantedAuthority.getAuthority()).replace("ROLE_", ""));
			if (role == null) {
				continue;
			}
			return role.getRole();
		}

		return null;
	}

}
